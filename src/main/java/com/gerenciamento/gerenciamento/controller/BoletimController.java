package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.BoletimService;
import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.ChaveBoletim;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;


@RestController
@RequestMapping("/boletim")
@AllArgsConstructor
public class BoletimController {
        private final BoletimService boletimService;


        @GetMapping("/{id}")
        public Boletim buscar(@PathVariable ChaveBoletim chaveBoletim){
            return boletimService.buscar(chaveBoletim);
        }

        @GetMapping
        public Collection buscarTodos() throws SQLException {
            return boletimService.buscarTodos();
        }

        @DeleteMapping
        public void remover(@RequestParam ChaveBoletim chaveBoletim) {
            boletimService.remover(chaveBoletim);
        }


        @PostMapping("/{turma_id}")
        public void inserir(@PathVariable Integer turma_id) {
            boletimService.salvar(turma_id);
        }

        @PutMapping("/{turma_id}")
        public void atualizar(@PathVariable Integer turma_id){
            boletimService.salvar(turma_id);
        }
        //Esta como integer epero que nao aconteça um erro
    }

