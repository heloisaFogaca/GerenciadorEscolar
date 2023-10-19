package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.DisciplinaService;
import com.gerenciamento.gerenciamento.Service.UsuarioService;
import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Disciplina;
import com.gerenciamento.gerenciamento.model.Professor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController{
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Aluno buscarAluno(@PathVariable Integer id) throws SQLException {
        return (Aluno) usuarioService.buscarUsuario(id);
    }

    @GetMapping
    public Collection buscarTodos() throws SQLException {
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void remover(@RequestParam Integer id) throws SQLException {
        usuarioService.remover(id);
    }

    @PostMapping
    public void inserir(@RequestBody Aluno aluno) throws SQLException {
        usuarioService.salvar(aluno);
    }

    @PutMapping
    public void atualizar(@RequestBody Aluno aluno){
        usuarioService.salvar(aluno);
    }
}
