package br.edu.alpha.faculdade.lab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {

    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("mensagem", "Insira seu nome abaixo:");
        return "formulario";
    }

    @GetMapping("/saudacao")
    public String saudacao(@RequestParam(required = false, defaultValue = "Mundo") String nome, Model model) {
        model.addAttribute("nome", nome);
        model.addAttribute("mensagem", String.format("Olá %s! Bem-vindo ao Thymeleaf (SSR)!", nome));
        return "saudacao";
    }

}
