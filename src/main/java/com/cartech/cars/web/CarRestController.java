package com.cartech.cars.web;

import com.cartech.cars.business.CarService;
import com.cartech.cars.data.entity.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {

    private final CarService carService;


    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        carService.saveCar(car);
        return new ResponseEntity<>(car,HttpStatus.CREATED);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

   @DeleteMapping("/cars/{carId}")
   public ResponseEntity<Void> deleteCar(@PathVariable Long carId){
       Post carToDelete = carService.getCarRepository().findByCarId(carId);
       carService.deleteCar(carToDelete);

       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }


}
