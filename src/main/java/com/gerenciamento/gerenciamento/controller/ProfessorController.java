package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.ProfessorService;
import com.gerenciamento.gerenciamento.Service.UsuarioService;
import com.gerenciamento.gerenciamento.model.Professor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/professor")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProfessorController {
    private ProfessorService usuarioService;

    @GetMapping("/{id}")
    public Professor buscarProfessor(@PathVariable Integer id){
        return (Professor) usuarioService.buscarUsuario(id);
    }

    @GetMapping
    public Collection buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void remover(@RequestParam Integer id){
        usuarioService.remover(id);
    }

    @PostMapping
    public void inserir(@RequestBody Professor professor){
        usuarioService.salvar(professor);
    }

    @PutMapping
    public void atualizar(@RequestBody Professor professor){
        usuarioService.salvar(professor);
    }
}
