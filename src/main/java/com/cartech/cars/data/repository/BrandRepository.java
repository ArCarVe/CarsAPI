package com.cartech.cars.data.repository;

import com.cartech.cars.data.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByBrandId(Long brandId);
    Brand findByName(String name);
    @Override
    List<Brand> findAll();

}
