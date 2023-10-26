package com.gerenciamento.gerenciamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private  int id;
    private String nome;

    @OneToMany(mappedBy = "turma")
    @JsonIgnore
    private Collection<Aluno> alunos;

}
