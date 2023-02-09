package com.abhijitkulkarni.personrestdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Person Rest Demo"))
public class PersonRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonRestDemoApplication.class, args);
	}

}
