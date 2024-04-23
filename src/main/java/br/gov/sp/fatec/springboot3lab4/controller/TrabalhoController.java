package br.gov.sp.fatec.springboot3lab4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3lab4.entity.Trabalho;
import br.gov.sp.fatec.springboot3lab4.service.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalho")
@CrossOrigin
public class TrabalhoController {
    
    @Autowired
    private TrabalhoService service;
    
    @GetMapping
    public List<Trabalho> getAll() {
        return service.getAllTrabalhos();
    }

    @GetMapping(value = "/{id}")
    public Trabalho findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping(value = "/note/{note}")
    public List<Trabalho> getByNote(@PathVariable("note") Long note) {
        return service.findByNote(note);
    } 
    
}
