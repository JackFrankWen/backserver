package com.jackfrank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Application {
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
