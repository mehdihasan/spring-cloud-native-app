package me.mh.turbineapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine // 110
public class TurbineAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineAppApplication.class, args);
	}

}
