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
        Brand brand = brandService.getBrandRepository().findByBrandId(brandId);
        
        model.setBrand(brand);
        modelService.saveModel(model);
        return new ResponseEntity<>(model,HttpStatus.CREATED);
    }

    @GetMapping("/models")
    public ResponseEntity<List<Model>> getAllModels(){
        return new ResponseEntity<>(modelService.getAllModels(), HttpStatus.OK);
    }

   @DeleteMapping("/models/{modelId}")
   public ResponseEntity<Void> deleteModel(@PathVariable Long modelId){
       Model modelToDelete = modelService.getModelRepository().findByModelId(modelId);
       modelService.deleteModel(modelToDelete);

       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }


}
