package com.github.javarushcommunity.javarush_telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
public class JavarushTelegramBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavarushTelegramBotApplication.class, args);
	}
	@PostMapping("/test-request")
	public ResponseEntity<String> testPostRequest(){
		return ResponseEntity.ok("POST request successful");
	}


}
