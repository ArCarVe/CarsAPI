package com.cartech.cars.data.entity;

import com.cartech.cars.data.entity.Model;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;

    
    public Brand() {}

    public Brand(String name) {
        this.name = name;
    }


    public Long getbrandId() {
        return brandId;
    }

    public void setbrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

}
