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
        try {
            usuarioRepository.findById(usuario.getId());
        } catch (NoSuchElementException e) {
            usuarioRepository.save(usuario);
        }
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario(Integer id) throws SQLException {
        return usuarioRepository.findById(id).get();
    }

    public Collection<Usuario> buscarTodos() throws SQLException {
        return usuarioRepository.findAll();
    }

    public void remover(Integer id) throws SQLException {
        usuarioRepository.deleteById(id);
    }

}