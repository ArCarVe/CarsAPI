package com.cartech.cars.data.entity;

import com.cartech.cars.data.entity.Generation;
import com.cartech.cars.data.entity.Brand;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelId;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "model")
    private List<Generation> generations;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    
    public Model() {}

    public Model(String name) {
        this.name = name;
    }


    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenerations(List<Generation> generations) {
        this.generations = generations;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
