package br.gov.sp.fatec.springboot3lab4.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab4.entity.Aluno;
import br.gov.sp.fatec.springboot3lab4.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository repository;

    public Aluno newAluno(Aluno aluno) {
        if(aluno == null || aluno.getAlu_nome_completo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados do aluno vazios!");
        }
        return repository.save(aluno);
    }

    public List<Aluno> getAllAlunos() {
        return repository.findAll();
    }

    public List<Aluno> getByWordOrDate(String palavra, LocalDate date) {
        return repository.findByWordOrDate(palavra, date);
    }
}
