package com.cartech.cars.data.repository;

import com.cartech.cars.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByCarId(Long carId);
    @Override
    List<Car> findAll();

}
