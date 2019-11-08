package me.mh.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 96
@EnableCircuitBreaker // 97
@RestController // 98
public class WeatherAppApplication {
	
	
	// 104
	@Autowired
	private WeatherService weatherService;
	

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}
	
	
	// 105
	@GetMapping("/current/weather")
	public String getWeather() {
		return "The current weather is: " + weatherService.getWeather();
	}
	
	
	// 99
	@Bean
	@LoadBalanced
	public RestTemplate restRTemplate() {
		return new RestTemplate();
	}
}
