package me.mh.configclientapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient // 28 - enabling as a discovery client 
@RestController // 34
@RefreshScope // 41 - basically, we use @Refreshscope to update @Value and @Bean properties in RUNTIME
public class ConfigClientAppApplication {

	// 32
	@Autowired
	private ConfigClientAppConfiguration properties;
	
	// 33
	@Value("${some.other.property}")
	private String someOtherProperty;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientAppApplication.class, args);
	}

	// 35
	@GetMapping()
	public String printConfig() {
		StringBuilder sb = new StringBuilder();
		sb.append(properties.getProperty());
		sb.append(" || ");
		sb.append(someOtherProperty);
		return sb.toString();
	}
}
