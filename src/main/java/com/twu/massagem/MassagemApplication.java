package com.twu.massagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.twu.massagem")

public class MassagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MassagemApplication.class, args);
		System.out.println();
	}
}