package com.ironhack.hellomoreweb.dto;

public class RobotMinimalRequest {
    private String model;
    private String name;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RobotMinimalRequest(String model, String name) {
        this.model = model;
        this.name = name;
    }
}
