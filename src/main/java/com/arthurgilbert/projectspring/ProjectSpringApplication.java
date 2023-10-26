package com.arthurgilbert.projectspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjectSpringApplication {

	public static void main(String[] args) {
			SpringApplication.run(ProjectSpringApplication.class, args);
	}

}
