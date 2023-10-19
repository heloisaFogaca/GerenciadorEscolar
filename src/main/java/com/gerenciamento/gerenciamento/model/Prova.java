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
    @OneToOne (cascade = CascadeType.PERSIST)
    private Professor professor;
    private double nota;
    @OneToOne (cascade = CascadeType.PERSIST)
    private Aluno aluno;
}
