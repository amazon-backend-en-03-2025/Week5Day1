package com.ironhack.hellomoreweb.model;

public class Robot {


    private Integer id; // Integer vs int
    private String model;
    private String manufacturer;
    private String  name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Robot(Integer id, String model, String name) {
        this.id = id;
        this.model = model;
        this.manufacturer = "Majorana Robotics";
        this.name = name;
    }
}
