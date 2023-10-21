package com.example.demo.services;

import com.example.demo.models.Coordinates;
import com.example.demo.models.Temperature;
import com.example.demo.models.TemperatureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;


import java.net.URI;
import java.util.Arrays;
import java.util.function.Function;

@Service
public class Weather {

    @Value("${data.API_KEY}")
    private String APIKey;

    @Autowired
    public WebClient client;

    public Coordinates[] getCoordinatesForCity(String city, String countryCode) {

        String url = "/geo/1.0/direct?q=" + city + ",," + countryCode + "&limit=1" + "&appid=" + APIKey;
        System.out.println(url);

        Coordinates[] coordinates = client.get().uri(url).retrieve().bodyToMono(Coordinates[].class).block();

        if(coordinates != null) {
            System.out.println("Coordinates exists!");
        } else {
            System.out.println("Coordinates is null");
        }

        return coordinates;

    }

    public TemperatureResponse getCurrentTemperature(double longitude, double latitude) throws Exception {
        String url = "/data/2.5/weather?lat=" + latitude + "&" + "lon=" + longitude + "&appid=" + APIKey;

        System.out.println(url);

        Temperature temperatures = client.get().uri(url).retrieve().bodyToMono(Temperature.class).block();

        if(temperatures != null) {
            if(temperatures.getTemperature() != null) {
                return temperatures.getTemperature();
            }
            throw new Exception("Temperatures invalid for this coordinates");
        }
        return temperatures.getTemperature();
    }
}
