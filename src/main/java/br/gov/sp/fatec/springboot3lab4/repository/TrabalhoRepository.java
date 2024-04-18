package br.gov.sp.fatec.springboot3lab4.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.gov.sp.fatec.springboot3lab4.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{
    
    @Query("SELECT t FROM Trabalho t WHERE t.tra_nota > :nota")
    public List<Trabalho> findyTituloByNota(@Param("nota") Long nota);
}
