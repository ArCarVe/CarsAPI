package com.cartech.cars.web;

import com.cartech.cars.business.CarService;
import com.cartech.cars.business.BrandService;
import com.cartech.cars.data.entity.Car;
import com.cartech.cars.data.entity.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {

    private final CarService carService;
    private final BrandService brandService;


    public CarRestController(CarService carService, BrandService brandService) {
        this.carService = carService;
        this.brandService = brandService;
    }

    @PostMapping("/brand/{brandId}/cars")
    public ResponseEntity<Car> createCar(@PathVariable(value = "brandId") Long brandId, @RequestBody Car car){

        Brand brand = brandService.getBrandRepository().findByBrandId(brandId);
        car.setBrand(brand);

        carService.saveCar(car);
        return new ResponseEntity<>(car,HttpStatus.CREATED);
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
