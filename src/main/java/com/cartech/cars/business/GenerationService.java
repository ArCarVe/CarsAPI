package com.cartech.cars.business;

import com.cartech.cars.data.entity.Generation;
import com.cartech.cars.data.repository.GenerationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerationService {

    private final GenerationRepository generationRepository;


    public GenerationService(GenerationRepository generationRepository) {
        this.generationRepository = generationRepository;
    }

    public Generation getGenerationById(Long generationId) {
        return getGenerationRepository().findByGenerationId(generationId);
    }

    public Generation getGenerationByName(String name) {
        return getGenerationRepository().findByName(name);
    }

    public void saveGeneration(Generation generation){
        getGenerationRepository().save(generation);
    }

    public List<Generation> getAllGenerations(){
        return getGenerationRepository().findAll();
    }

    public void deleteGeneration(Generation generation){
        getGenerationRepository().delete(generation);
    }

    public GenerationRepository getGenerationRepository() {
        return generationRepository;
    }
}
