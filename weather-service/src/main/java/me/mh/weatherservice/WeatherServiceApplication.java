package me.mh.weatherservice;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 89
@EnableDiscoveryClient // 90
@SpringBootApplication
public class WeatherServiceApplication {

	
	// 91
	private String[] weather = new String[]{"Sunny", "Cloudy", "Rainy", "Windy"};
	
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	
	// 92
	@GetMapping("/weather")
	public String getWeather() {
		int rand = ThreadLocalRandom.current().nextInt(0, 4);
		return weather[rand];
	}
}
