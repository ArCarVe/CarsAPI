package com.cartech.cars.web;

import com.cartech.cars.business.GenerationService;
import com.cartech.cars.business.ModelService;
import com.cartech.cars.data.entity.Generation;
import com.cartech.cars.data.entity.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenerationRestController {

    private final GenerationService generationService;
    private final ModelService modelService;


    public GenerationRestController(GenerationService generationService, ModelService modelService) {
        this.generationService = generationService;
        this.modelService = modelService;
    }

    @PostMapping("/model/{modelId}/generations")
    public ResponseEntity<Generation> createGeneration(@PathVariable(value = "modelId") Long modelId, @RequestBody Generation generation){
        Model model = modelService.getModelRepository().findByModelId(modelId);
        
        generation.setModel(model);
        generationService.saveGeneration(generation);
        return new ResponseEntity<>(generation,HttpStatus.CREATED);
    }

    @GetMapping("/generations")
    public ResponseEntity<List<Generation>> getAllGenerations(){
        return new ResponseEntity<>(generationService.getAllGenerations(), HttpStatus.OK);
    }

   @DeleteMapping("/generations/{generationId}")
   public ResponseEntity<Void> deleteGeneration(@PathVariable Long generationId){
       Generation generationToDelete = generationService.getGenerationRepository().findByGenerationId(generationId);
       generationService.deleteGeneration(generationToDelete);

       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }


}
