package br.gov.sp.fatec.springboot3lab4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab4.entity.Trabalho;
import br.gov.sp.fatec.springboot3lab4.repository.TrabalhoRepository;

@Service
public class TrabalhoService {
    
    @Autowired
    private TrabalhoRepository repository;

    public Trabalho newTrabalho(Trabalho trabalho) {
        if(trabalho == null || trabalho.getTra_titulo().isBlank())
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados de usuário inválidos!");
        return repository.save(trabalho);
    }

    public List<Trabalho> getAllTrabalhos() {
        return repository.findAll();
    }

    public Trabalho findById(Long id) {
        Optional<Trabalho> trabalhoOp = repository.findById(id);
        if(trabalhoOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho not found");
        } return trabalhoOp.get();

    }

    public List<Trabalho> findByNote(Long nota) {
        return repository.findyTituloByNota(nota);
    }
    
    
}
