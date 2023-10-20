package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.BoletimService;
import com.gerenciamento.gerenciamento.Service.UsuarioService;
import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Boletim;
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
        public Boletim buscar(@PathVariable Integer id) throws SQLException {
            return boletimService.buscar(id);
        }

        @GetMapping
        public Collection buscarTodos() throws SQLException {
            return boletimService.buscarTodos();
        }

        @DeleteMapping
        public void remover(@RequestParam Integer id) throws SQLException {
            boletimService.remover(id);
        }

        @PostMapping
        public void inserir(@RequestBody Boletim boletim) throws SQLException {
            boletimService.salvar(boletim);
        }

        @PutMapping
        public void atualizar(@RequestBody Boletim boletim){
            boletimService.salvar(boletim);
        }
    }
