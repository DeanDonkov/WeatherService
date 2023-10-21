package com.example.demo;

import com.example.demo.models.Coordinates;
import com.example.demo.models.TemperatureResponse;
import com.example.demo.services.Weather;
import com.example.demo.utils.UnitParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);


	}

}
