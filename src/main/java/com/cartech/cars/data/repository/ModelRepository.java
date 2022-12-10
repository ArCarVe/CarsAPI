package com.cartech.cars.data.repository;

import com.cartech.cars.data.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    Model findByModelId(Long carId);
    @Override
    List<Model> findAll();

}
