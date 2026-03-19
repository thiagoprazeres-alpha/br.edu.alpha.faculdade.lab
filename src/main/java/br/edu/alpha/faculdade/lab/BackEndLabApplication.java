package br.edu.alpha.faculdade.lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackEndLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndLabApplication.class, args);
	}

	@Bean
	public CommandLineRunner helloTerminal() {
		return args -> {
			String nome = "Mundo";
			if (args.length > 0 && args[0] != null && !args[0].isBlank()) {
				nome = args[0];
			}
			System.out.println(String.format("Olá %s do terminal!", nome));
		};
	}

}
