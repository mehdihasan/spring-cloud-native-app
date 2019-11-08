package me.mh.ribbonclienttimeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import me.mh.config.RibbonTimeConfig;

@RestController // 79
@RibbonClient(name = "time-service-discoverydisabled", configuration = RibbonTimeConfig.class) // 80
@SpringBootApplication()
public class RibbonclientTimeAppApplication {

	// 81
	@Autowired
	private RestTemplate restTemplate;
	
		
	public static void main(String[] args) {
		SpringApplication.run(RibbonclientTimeAppApplication.class, args);
	}


	// 82
	@Bean
	@LoadBalanced /// this @LoadBalanced annotation is the trickiest part for the client side load balancing
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	// 83
	@GetMapping("/")
	public String getTime() {
		return restTemplate.getForEntity("http://time-service-discoverydisabled", String.class).getBody();
	}
}
