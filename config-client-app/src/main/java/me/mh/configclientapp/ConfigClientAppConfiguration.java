package me.mh.configclientapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // 29
@ConfigurationProperties(prefix = "some") // 30 - 
public class ConfigClientAppConfiguration {

	// 31
	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}	
}
