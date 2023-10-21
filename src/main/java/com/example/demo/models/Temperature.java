package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {

    @JsonProperty("main")
    private TemperatureResponse current;

    public Temperature(){}

    public Temperature(TemperatureResponse temperature) {
        this.current = temperature;
    }

    public TemperatureResponse getTemperature() {
        return current;
    }

    public void setTemperature(TemperatureResponse temperature) {
        this.current = temperature;
    }
}
