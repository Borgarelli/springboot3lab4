package br.gov.sp.fatec.springboot3lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3lab4.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho,Long>{
    
    @Query("Select * FROM tra_trabalho t WHERE ")
}
