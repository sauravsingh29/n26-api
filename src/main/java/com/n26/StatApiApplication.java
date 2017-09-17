package com.n26;

import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class StatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatApiApplication.class, args);
		System.out.println(Instant.now().toEpochMilli());
	}
}
