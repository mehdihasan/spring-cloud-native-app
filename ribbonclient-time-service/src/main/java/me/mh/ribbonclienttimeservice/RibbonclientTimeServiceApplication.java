package me.mh.ribbonclienttimeservice;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 74
@SpringBootApplication
public class RibbonclientTimeServiceApplication {

	// 75
	@Value("${server.port}")
	private int port;
		
	public static void main(String[] args) {
		SpringApplication.run(RibbonclientTimeServiceApplication.class, args);
	}

	
	// 76
	@GetMapping("/")
	public String getTime() {
		return "The current time is " 
					+ ZonedDateTime.now().toString()
					+ "\n(answered by service running on "+ port +")";
	}
}
