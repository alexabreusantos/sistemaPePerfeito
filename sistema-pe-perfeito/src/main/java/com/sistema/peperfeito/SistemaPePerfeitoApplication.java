package com.sistema.peperfeito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.sistema.peperfeito.config.property.PePerfeitoProperty;

@SpringBootApplication
@EnableConfigurationProperties(PePerfeitoProperty.class)
public class SistemaPePerfeitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPePerfeitoApplication.class, args);
	}

}
