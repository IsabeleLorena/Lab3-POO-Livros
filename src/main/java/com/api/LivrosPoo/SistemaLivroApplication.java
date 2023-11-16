package com.api.LivrosPoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SistemaLivroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaLivroApplication.class, args);
	}

	@GetMapping ("/")
	public String index (){
		return "Olá mundo";
	}
}
