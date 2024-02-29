package br.gov.sp.fatec.springboot3lab4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3lab4.Domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    
}
