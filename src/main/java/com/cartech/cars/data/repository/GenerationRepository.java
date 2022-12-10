package com.cartech.cars.data.repository;

import com.cartech.cars.data.entity.Generation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Long> {

    Generation findByGenerationId(Long carId);
    @Override
    List<Generation> findAll();

}
