package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Prova {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String nome;
    @ManyToOne
    private Professor professor;
    private double nota;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Turma turma;
    @ManyToOne
    private Disciplina disciplina;

   // Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails
       //     (`gerenciamentoescolar`.`prova`, CONSTRAINT `FK84tria80qb5f7e8getyl5s9jk` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`))


}
