package me.mh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration // 87
public class RibbonTimeConfig { // 86

	// 88
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
}
