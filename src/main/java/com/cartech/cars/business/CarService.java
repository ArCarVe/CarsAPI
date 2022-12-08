package com.cartech.cars.business;

import com.cartech.cars.data.entity.Car;
import com.cartech.cars.data.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCar(Car car){
        getCarRepository().save(car);
    }

    public List<Car> getAllCars(){
        return getCarRepository().findAll();
    }

    public void deleteCar(Car car){
        getCarRepository().delete(car);
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }
}
