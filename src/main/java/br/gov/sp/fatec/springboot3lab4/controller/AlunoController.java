package br.gov.sp.fatec.springboot3lab4.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3lab4.entity.Aluno;
import br.gov.sp.fatec.springboot3lab4.service.AlunoService;

@RestController
@RequestMapping(value ="/aluno")
@CrossOrigin
public class AlunoController {
    
    @Autowired
    private AlunoService service;

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAllAlunos();
    }

    @GetMapping(value = "/especifico/{palavra}/{data}")
    public List<Aluno> getByWordOrDate(@PathVariable("palavra") String palavra, @PathVariable("data") LocalDate data) {
        return service.getByWordOrDate(palavra, data);
    }
    
    @PostMapping
    public Aluno newAluno(@RequestBody Aluno aluno) {
        return service.newAluno(aluno);
    }
}
