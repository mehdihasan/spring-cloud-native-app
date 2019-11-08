package me.mh.ribbontimeservice;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 62
@EnableDiscoveryClient // 63
@SpringBootApplication
public class RibbonTimeServiceApplication {

	// 64
	@Value("${server.port}")
	private int port;
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeServiceApplication.class, args);
	}

	// 65
	@GetMapping("/")
	public String getTime() {
		return "The current time is " 
					+ ZonedDateTime.now().toString()
					+ "\n(answered by service running on "+ port +")";
	}
}
