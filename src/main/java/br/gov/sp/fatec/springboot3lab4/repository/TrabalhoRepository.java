package br.gov.sp.fatec.springboot3lab4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3lab4.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho,Long>{
    
    // @Query("Select t FROM tra_trabalho t WHERE t.tra_nota > t.tra_titulo")
    // public List<Trabalho> findyTituloByNota(String titulo, long nota);
}
