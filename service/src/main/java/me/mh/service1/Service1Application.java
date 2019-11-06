package me.mh.service1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient // 6 - enabling discovery client. It causes to register itself to the discovery server when it starts-up
@SpringBootApplication
@RestController // 7 - making a rest controller 
public class Service1Application {

	// 9 - we want multiple instance of the service application
	@Value("${service.instance.name}")
	private String instance;
	
	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
	
	// 8 - defining home page with some message 
	@GetMapping("/")
	public String message() {
		return "Hello from " + instance;
	}

}
