package me.mh.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@EnableDiscoveryClient // 13 - defining as discovery client 
@SpringBootApplication
@RestController // 14 - defining this as a rest controller
public class ClientApplication {
	
	// 16 - defining the Discovery / Eureka client
	@Autowired
	private EurekaClient client;
	
	// 17 - defining a rest template so that we can call the service
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	// 15 - create a handler method to access home page
	@GetMapping("/")
	public String callService() {
		
		// 18 - search for required service and use the service to get response and return the result
		RestTemplate template = restTemplateBuilder.build();
		InstanceInfo instanceInfo =  client.getNextServerFromEureka("service", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		ResponseEntity<String> response = template.exchange(baseUrl, HttpMethod.GET, null, String.class);
		return response.getBody();
	}
}
