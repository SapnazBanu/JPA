package com.xworkz.travelPlaces.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.travelPlaces")
@EnableWebMvc
public class WebConfiguration {

	public WebConfiguration() {

	}

}