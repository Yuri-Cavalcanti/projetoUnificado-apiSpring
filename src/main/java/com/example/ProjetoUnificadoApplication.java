package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
//@EntityScan("com.exemplo.datasource.model") //para escanear um package de entidades
public class ProjetoUnificadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoUnificadoApplication.class, args);
	}

}
