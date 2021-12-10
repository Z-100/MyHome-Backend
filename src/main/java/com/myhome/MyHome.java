package com.myhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MyHome {

	public static void main(String[] args) {
		SpringApplication.run(MyHome.class, args);
	}
}
