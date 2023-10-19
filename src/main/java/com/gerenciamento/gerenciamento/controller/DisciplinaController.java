package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.DisciplinaService;
import com.gerenciamento.gerenciamento.model.Disciplina;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/disciplina")
@AllArgsConstructor
public class DisciplinaController {
    private DisciplinaService disciplinaService;

    @GetMapping("/{id}")
    public Disciplina buscarDisciplina(@PathVariable Integer id) {
        return disciplinaService.buscarDisciplina(id);
    }

    @GetMapping
    public Collection buscarTodos() {
        return disciplinaService.buscarTodos();
    }

    @DeleteMapping
    public void remover(@RequestParam Integer id) {
        disciplinaService.remover(id);
    }

    @PostMapping
    public void inserir(@RequestBody Disciplina disciplina){
        disciplinaService.salvar(disciplina);
    }

    @PutMapping
    public void atualizar(@RequestBody Disciplina disciplina){
        disciplinaService.salvar(disciplina);
    }
}
