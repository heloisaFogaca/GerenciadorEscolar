package com.gerenciamento.gerenciamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String nome;
    @JsonIgnore
    @OneToMany(mappedBy="turma")
    private List<Aluno> alunos;
    @JsonIgnore
    @OneToMany(mappedBy="turma")
    private List<Professor> professores;

}
