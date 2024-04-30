package br.gov.sp.fatec.springboot3lab4.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.springboot3lab4.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
    @Query("SELECT a FROM Aluno a WHERE a.alu_nome_completo LIKE %:palavra% OR a.alu_data_matricula < :data")
    public List<Aluno> findByWordOrDate(@Param("palavra") String palavra, @Param("data") LocalDate data);
    
}
