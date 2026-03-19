package br.edu.alpha.faculdade.lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/olamundo")
    public String helloWeb(@RequestParam(name = "nome", required = false, defaultValue = "Mundo") String nome) {
        return String.format("Olá %s da web!", nome);
    }

}