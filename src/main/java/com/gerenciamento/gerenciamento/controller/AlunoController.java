package com.gerenciamento.gerenciamento.controller;


import com.gerenciamento.gerenciamento.Service.AlunoService;
import com.gerenciamento.gerenciamento.Service.UsuarioService;
import com.gerenciamento.gerenciamento.model.Aluno;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController{
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public Aluno buscarAluno(@PathVariable Integer id) throws SQLException {
        return (Aluno) alunoService.buscarUsuario(id);
    }

    @GetMapping
    public Collection buscarTodos() throws SQLException {
        return alunoService.buscarTodos();
    }

    @DeleteMapping
    public void remover(@RequestParam Integer id) throws SQLException {
        alunoService.remover(id);
    }

    @PostMapping
    public void inserir(@RequestBody Aluno aluno) throws SQLException {
        alunoService.salvar(aluno);
    }

    @PutMapping
    public void atualizar(@RequestBody Aluno aluno){
        alunoService.salvar(aluno);
    }
}
