package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Collection;

@Embeddable
public class ChaveBoletim {

    @ManyToOne
    private Aluno aluno;
    @OneToOne
    private Disciplina disciplina;
    @ManyToOne
    private Turma turma;

}
