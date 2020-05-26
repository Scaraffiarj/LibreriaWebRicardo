package com.edu.egg.libreriaWebRicardo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.edu.egg.libreriaWebRicardo"})
public class LibreriaWebRicardoApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(LibreriaWebRicardoApplication.class, args);
	}

}