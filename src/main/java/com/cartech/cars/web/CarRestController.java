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

//    @DeleteMapping("/posts/{postId}")
//    public ResponseEntity<Void> deletePost(@PathVariable Long postId){
//        Post postToDelete = carService.getPostRepository().findByPostId(postId);
//        carService.deletePost(postToDelete);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


}
