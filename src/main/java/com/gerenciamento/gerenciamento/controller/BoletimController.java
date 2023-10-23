package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.BoletimService;
import com.gerenciamento.gerenciamento.Service.SecretarioService;
import com.gerenciamento.gerenciamento.Service.TurmaService;
import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.Secretario;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;


@RestController
@RequestMapping("/boletim")
@AllArgsConstructor
public class BoletimController {

    private SecretarioService secretarioS;
    private AlunoController aluno;
    BoletimService boletimService;

    @GetMapping("/{id}")
    public Boletim buscar(@PathVariable Integer chaveBoletim) throws SQLException {
        return boletimService.buscar(chaveBoletim);
    }

    @GetMapping
    public Collection buscarTodos() throws SQLException {
        return boletimService.buscarTodos();
    }

    @DeleteMapping
    public void remover(@RequestParam Integer chaveBoletim) throws SQLException {
        boletimService.remover(chaveBoletim);
    }

    @PostMapping
    public void inserir(@RequestBody Integer id) throws SQLException {
        boletimService.salvar(secretarioS.gerarBoletim(aluno.buscarAluno(id)));

    }

    @PutMapping
    public void atualizar(@RequestBody Boletim boletim){
        boletimService.salvar(boletim);
    }
}
