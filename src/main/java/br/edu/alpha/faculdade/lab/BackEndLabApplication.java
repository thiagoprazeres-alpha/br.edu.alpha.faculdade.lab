package br.edu.alpha.faculdade.lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class BackEndLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndLabApplication.class, args);
	}

	@Bean
	public CommandLineRunner helloTerminal() {
		return args -> {
			new Thread(() -> {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Digite seu nome: ");
				String nome = scanner.nextLine();
				if (nome == null || nome.isBlank()) {
					nome = "Mundo";
				}
				System.out.println(String.format("Olá %s do terminal!", nome));
			}).start();
		};
	}

}
