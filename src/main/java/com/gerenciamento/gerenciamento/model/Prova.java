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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Professor professor;
    private double nota;
    @ManyToOne
    private Aluno aluno;
}
