package com.br.faccat.sistdist.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {

    @Value("${spring.application.name}")
    private String appName;
    @GetMapping
    public String teste(){
        return "Teste servico distribuido rodando totalmente em container: " + appName + ".\n";
    }
}
