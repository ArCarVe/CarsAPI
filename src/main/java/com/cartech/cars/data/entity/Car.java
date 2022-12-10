package com.cartech.cars.data.entity;

import com.cartech.cars.data.entity.Generation;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "start_production_year")
    private int startProductionYear;

    @Column(name = "end_production_year")
    private int endProductionYear;

    @Column(name = "seats")
    private int seats;

    @Column(name = "doors")
    private int doors;

    @Column(name = "modification")
    private String modification;

    @ManyToOne
    @JoinColumn(name = "generation_id")
    private Generation generation;

    public Car() {}

    public Car(int startProductionYear, int endProductionYear, int seats, int doors, String modification) {
        this.startProductionYear = startProductionYear;
        this.endProductionYear = endProductionYear;
        this.seats = seats;
        this.doors = doors;
        this.modification = modification;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public int getStartProductionYear() {
        return startProductionYear;
    }

    public void setStartProductionYear(int startProductionYear) {
        this.startProductionYear = startProductionYear;
    }

    public int getEndProductionYear() {
        return endProductionYear;
    }

    public void setEndProductionYear(int endProductionYear) {
        this.endProductionYear = endProductionYear;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }
}
