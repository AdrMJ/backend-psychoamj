package com.psychoamj.aj4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.psychoamj.aj4")
public class PsychoAmjApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsychoAmjApplication.class, args);
	}

}
