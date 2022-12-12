package com.cartech.cars.business;

import com.cartech.cars.data.entity.Model;
import com.cartech.cars.data.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    private final ModelRepository modelRepository;


    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    public Model getModelById(Long modelId) {
        return getModelRepository().findByModelId(modelId);
    }

    public Model getModelByName(String name) {
        return getModelRepository().findByName(name);
    }

    public void saveModel(Model model){
        getModelRepository().save(model);
    }

    public List<Model> getAllModels(){
        return getModelRepository().findAll();
    }

    public void deleteModel(Model model){
        getModelRepository().delete(model);
    }

    public ModelRepository getModelRepository() {
        return modelRepository;
    }
}
