package com.example.demo.controller;

import com.example.demo.models.Coordinates;
import com.example.demo.models.TemperatureResponse;
import com.example.demo.services.Weather;
import com.example.demo.utils.UnitParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private ApplicationContext context;


    @GetMapping("/{city}/{countryCode}")
    public ResponseEntity getTemperature(@PathVariable String city, @PathVariable String countryCode) {

        Weather bean = context.getBean(Weather.class);
        UnitParser unitParser = context.getBean(UnitParser.class);

        Coordinates[] currentCoordinates = bean.getCoordinatesForCity(city, countryCode);

        if(currentCoordinates.length == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordinates not found!");
        }

        try {
            TemperatureResponse response = bean.getCurrentTemperature(currentCoordinates[0].getLongitude(), currentCoordinates[0].getLatitude());

            double parsedTemp = unitParser.convertKelvinToCelsius(response.getTemp());
            double parsedFeelsLike = unitParser.convertKelvinToCelsius(response.getFeelsLike());
            double tempMax = unitParser.convertKelvinToCelsius(response.getTemp_max());


            response.setTemp(parsedTemp);
            response.setFeelsLike(parsedFeelsLike);
            response.setTemp_max(tempMax);
            return ResponseEntity.ok(response);


        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return ResponseEntity.badRequest().build();
        }

    }
}
