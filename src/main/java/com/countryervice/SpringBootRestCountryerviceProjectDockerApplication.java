package com.countryervice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.countryservices")
public class SpringBootRestCountryerviceProjectDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestCountryerviceProjectDockerApplication.class, args);
	}

}
