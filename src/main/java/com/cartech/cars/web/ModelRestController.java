package com.cartech.cars.web;

import com.cartech.cars.business.ModelService;
import com.cartech.cars.business.BrandService;
import com.cartech.cars.data.entity.Model;
import com.cartech.cars.data.entity.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModelRestController {

    private final ModelService modelService;
    private final BrandService brandService;

    public ModelRestController(ModelService modelService, BrandService brandService) {
        this.modelService = modelService;
        this.brandService = brandService;
    }

    @PostMapping("/brand/{brandId}/models")
    public ResponseEntity<Model> createModel(@PathVariable(value = "brandId") Long brandId, @RequestBody Model model){
        Model modelDB = modelService.getModelByName(model.getName());
        if (modelDB != null) {
            return new ResponseEntity<>(modelDB, HttpStatus.CONFLICT);
        }
        try {
            Brand brand = brandService.getBrandById(brandId);
        
            model.setBrand(brand);
            modelService.saveModel(model);
        } catch (Exception e) {
            return new ResponseEntity<>(model, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @GetMapping("/models")
    public ResponseEntity<List<Model>> getAllModels() {
        return new ResponseEntity<>(modelService.getAllModels(), HttpStatus.OK);
    }

    @DeleteMapping("/models/{modelId}")
    public ResponseEntity<Void> deleteModel(@PathVariable Long modelId) {
        Model modelToDelete = modelService.getModelById(modelId);
        modelService.deleteModel(modelToDelete);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
