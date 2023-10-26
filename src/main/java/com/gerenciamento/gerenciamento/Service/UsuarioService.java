package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Usuario;
import com.gerenciamento.gerenciamento.repository.UsuarioRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario(Integer id){
        return usuarioRepository.findById(id).get();
    }

    public Collection<Usuario> buscarTodos()  {
        return usuarioRepository.findAll();
    }

    public void remover(Integer id) {
        usuarioRepository.deleteById(id);
    }

}