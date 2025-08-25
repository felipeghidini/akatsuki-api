package com.akatsuki.api.controllers;

import com.akatsuki.api.entities.Personagem;
import com.akatsuki.api.repositories.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("personagem")
public class PersonagemController {

    @Autowired
    private PersonagemRepository personagemRepository;

    @GetMapping
    public List<Personagem> listarTodos() {
        return personagemRepository.findAll();
    }
}
