package com.cartech.cars.data.entity;

import com.cartech.cars.data.entity.Car;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "generation")
public class Generation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generationId;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_production_year")
    private int startProductionYear;

    @Column(name = "end_production_year")
    private int endProductionYear;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "generation")
    private List<Car> cars;

    
    public Generation() {}

    public Generation(int startProductionYear, int endProductionYear, String name) {
        this.startProductionYear = startProductionYear;
        this.endProductionYear = endProductionYear;
        this.name = name;
    }


    public Long getGenerationId() {
        return generationId;
    }

    public void setGenerationId(Long generationId) {
        this.generationId = generationId;
    }

    public String getName() {
        return name;
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

}
