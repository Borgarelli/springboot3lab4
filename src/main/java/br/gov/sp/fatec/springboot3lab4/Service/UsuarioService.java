package br.gov.sp.fatec.springboot3lab4.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab4.Domain.Usuario;
import br.gov.sp.fatec.springboot3lab4.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario createUser(Usuario usuario){
        if(usuario == null || usuario.getNome().isBlank()
                            || usuario.getNome() == null
                            || usuario.getSenha().isBlank()
                            || usuario.getSenha() == null) {
                                throw new ResponseStatusException(HttpStatus.BAD_REQUEST); 
                            }
        else {
            return usuarioRepository.save(usuario);
        }
    }

    public Usuario getById(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);
        if(usuarioOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            return usuarioOp.get();
        }
    }
}
