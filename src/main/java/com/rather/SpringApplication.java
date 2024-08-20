package com.rather;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringApplication{
	public static void main(String[] args) {
		Application.launch(JavaFxApplication.class, args);
	}
}
