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

    @Column(name = "seats")
    private int seats;

    @Column(name = "doors")
    private int doors;

    @Column(name = "hp")
    private int hp;

    @Column(name = "is_automatic")
    private Boolean isAutomatic;

    @Column(name = "modification")
    private String modification;

    @ManyToOne
    @JoinColumn(name = "generation_id")
    private Generation generation;

    public Car() {}

    public Car(int seats, int doors, int hp, Boolean isAutomatic, String modification) {
        this.hp = hp;
        this.seats = seats;
        this.doors = doors;
        this.isAutomatic = isAutomatic;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public Boolean getIsAutomatic() {
        return isAutomatic;
    }

    public void setIsAutomatic(Boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }
}
