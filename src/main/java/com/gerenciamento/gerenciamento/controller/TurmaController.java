package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.TurmaService;
import com.gerenciamento.gerenciamento.model.Turma;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/turma")
@AllArgsConstructor
public class TurmaController {
    private final TurmaService turmaService;

    @GetMapping("/{id}")
    public Turma buscarTurma(@PathVariable Integer id)   {
        return turmaService.buscarTurma(id);
    }

    @GetMapping
    public Collection buscarTodos()   {
        return turmaService.buscarTodos();
    }

    @DeleteMapping
    public void remover(@RequestParam Integer id)   {
        turmaService.remover(id);
    }

    @PostMapping
    public void inserir(@RequestBody Turma turma) {
        turmaService.salvar(turma);
    }

    @PutMapping
    public void atualizar(@RequestBody Turma turma) {
        turmaService.salvar(turma);
    }
}