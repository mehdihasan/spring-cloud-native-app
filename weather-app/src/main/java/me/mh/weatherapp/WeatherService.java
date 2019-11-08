package me.mh.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

// 100
@Service
public class WeatherService {


	// 101
	@Autowired
	private RestTemplate restTemplate;
	
	
	// 102
	@HystrixCommand(fallbackMethod = "unknown")
	public String getWeather() {
		return restTemplate.getForEntity("http://weather-service/weather", String.class).getBody();
	}
	
	
	// 103
	public String unknown() {
		return "Unknown";
	}
}
