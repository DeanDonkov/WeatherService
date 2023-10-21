package com.example.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class UnitParser {

    public double convertKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}
