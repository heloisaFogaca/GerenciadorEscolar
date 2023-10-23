package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.BoletimService;
import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.ChaveBoletim;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;


@RestController
@RequestMapping("/boletim")
@AllArgsConstructor
public class BoletimController {
        private BoletimService boletimService;

        @GetMapping("/{id}")
        public Boletim buscar(@PathVariable ChaveBoletim chaveBoletim) throws SQLException {
            return boletimService.buscar(chaveBoletim);
        }

        @GetMapping
        public Collection buscarTodos() throws SQLException {
            return boletimService.buscarTodos();
        }

        @DeleteMapping
        public void remover(@RequestParam ChaveBoletim chaveBoletim) throws SQLException {
            boletimService.remover(chaveBoletim);
        }

        @PostMapping
        public void inserir(@RequestBody Aluno aluno) throws SQLException {
            boletimService.salvar(aluno);
        }

        @PutMapping
        public void atualizar(@RequestBody Aluno aluno){
            boletimService.salvar(aluno);
        }
    }
