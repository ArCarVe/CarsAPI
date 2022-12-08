package com.cartech.cars.data.entity;

import com.cartech.cars.data.entity.Brand;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @NotNull
    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Car() {}

    public Car(Long carId, String model, int year) {
        this.carId = carId;
        this.model = model;
        this.year = year;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
