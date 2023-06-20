package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

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

		List<Integer> httpErrorCodes = Arrays.asList(
                300, 301, 302, 303, 304, 305, 307, 300, 301, 302, 303, 304, 305, 307,300, 301, 302, 303, 304, 305, 307,
                 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406, 401,
                403, 404,  406,
                 500, 501, 502, 503, 504,
                505, 506, 507, 508, 510, 511, 500, 501, 502, 503, 504,
                505, 506, 507, 508, 510, 511, 500, 501, 502, 503, 504,
                505, 506, 507, 508, 510, 511,
				200, 200, 200, 200, 200, 200, 200, 200,200, 200,200, 200, 200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,
				200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,
				200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,
				200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,
				200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,
				200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200,200, 200
        );

        int randomIndex = getRandomIndex(httpErrorCodes.size());
        int randomHttpErrorCode = httpErrorCodes.get(randomIndex);

        //Random random = new Random();
        //int statusCode = random.nextInt(100) + 300; // Generates a random number between 300 and 500 (inclusive)
        return HttpStatus.valueOf(randomHttpErrorCode);
    }

	private static int getRandomIndex(int listSize) {
        Random random = new Random();
        return random.nextInt(listSize);
    }
}
