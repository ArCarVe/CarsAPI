package com.cartech.cars.web;

import com.cartech.cars.business.CarService;
import com.cartech.cars.business.GenerationService;
import com.cartech.cars.data.entity.Car;
import com.cartech.cars.data.entity.Generation;
import com.cartech.cars.data.entity.Model;
import com.cartech.cars.data.entity.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {

    private final CarService carService;
    private final GenerationService generationService;


    public CarRestController(CarService carService, GenerationService generationService) {
        this.carService = carService;
        this.generationService = generationService;
    }

    @PostMapping("/generation/{generationId}/cars")
    public ResponseEntity<Car> createCar(@PathVariable(value = "generationId") Long generationId, @RequestBody Car car){
        Generation generation = generationService.getGenerationRepository().findByGenerationId(generationId);
        
        car.setGeneration(generation);
        
        carService.saveCar(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @DeleteMapping("/cars/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId){
        Car carToDelete = carService.getCarRepository().findByCarId(carId);
        carService.deleteCar(carToDelete);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
