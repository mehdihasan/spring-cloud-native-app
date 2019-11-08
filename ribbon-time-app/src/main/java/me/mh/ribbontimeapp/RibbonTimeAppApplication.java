package me.mh.ribbontimeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController // 68
@EnableDiscoveryClient // 69
@SpringBootApplication
public class RibbonTimeAppApplication {

	// 70
	@Autowired
	private RestTemplate restTemplate;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeAppApplication.class, args);
	}
	
	
	// 71
	@Bean
	@LoadBalanced /// this @LoadBalanced annotation is the trickiest part for the client side load balancing
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	// 72
	@GetMapping("/")
	public String getTime() {
		return restTemplate.getForEntity("http://time-service", String.class).getBody();
	}
}
