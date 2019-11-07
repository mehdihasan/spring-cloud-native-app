package me.mh.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.mh.gatewayservice.filters.AddRequestHeaderFilter;

@SpringBootApplication
@EnableZuulProxy // 42 - enabling Zuul proxy serevr
@EnableDiscoveryClient // 43 - enabling this as a discovery client  
@Configuration // 59
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	// 60
	@Bean
	public AddRequestHeaderFilter addRequestHeaderFilter() {
		return new AddRequestHeaderFilter();
	} 
}
