package com.keuss.book.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApiApplication {

	public static void main(String[] args) {
		// See swagger-ui home http://localhost:8080/swagger-ui/index.html
		SpringApplication.run(BookApiApplication.class, args);
	}

}
