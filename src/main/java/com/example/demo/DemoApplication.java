package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Random;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		return "Hello Azure!";
	}

	@RequestMapping("/status")
    ResponseEntity<String> status() {
        HttpStatus randomStatus = getRandomStatusCode();
        return ResponseEntity.status(randomStatus).body("Hello Azure! Random Status: " + randomStatus);
    }

    private HttpStatus getRandomStatusCode() {
        Random random = new Random();
        int statusCode = random.nextInt(201) + 300; // Generates a random number between 300 and 500 (inclusive)
        return HttpStatus.valueOf(statusCode);
    }
}
