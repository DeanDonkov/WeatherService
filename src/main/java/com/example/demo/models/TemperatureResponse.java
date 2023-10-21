package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureResponse {
    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;


    private double temp_max;

    public TemperatureResponse(){}

    public TemperatureResponse(double temp, double feelsLike) {
        this.temp = temp;
        this.feelsLike = feelsLike;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }
}
