package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.ProvaService;
import com.gerenciamento.gerenciamento.model.Prova;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/prova")
@AllArgsConstructor
public class ProvaController {
    private ProvaService provaService;

    @GetMapping("/{id}")
    public Prova buscarProva(@PathVariable Integer id)   {
        return provaService.buscarProva(id);
    }

    @GetMapping
    public Collection buscarTodos()   {
        return provaService.buscarTodos();
    }

    @DeleteMapping
    public void remover(@RequestParam Integer id)   {
        provaService.remover(id);
    }

    @PostMapping
    public void inserir(@RequestBody Prova prova) {
        provaService.salvar(prova);
    }

    @PutMapping
    public void atualizar(@RequestBody Prova prova) {
        provaService.salvar(prova);
    }
}