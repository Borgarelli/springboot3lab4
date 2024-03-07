package br.gov.sp.fatec.springboot3lab4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3lab4.Domain.Usuario;
import br.gov.sp.fatec.springboot3lab4.Service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario) {
        return usuarioService.createUser(usuario);
    }

    @GetMapping
    public List<Usuario> buscarTodos() {
        return usuarioService.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public Usuario getUserById(@PathVariable("id") Long id) {
        return usuarioService.getById(id);
    }
    
}
