package net.javaguides.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
//@OpenAPIDefinition
public class EmployeeServiceApplication {

//	This is configured using REST TEMPLATE--it is going to be deprecated soon
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//
//	}
//now we configured Web client as Spring Bean

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
