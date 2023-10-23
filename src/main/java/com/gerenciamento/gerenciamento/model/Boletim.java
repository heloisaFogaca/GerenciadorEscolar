package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boletim {

    @EmbeddedId
    private ChaveBoletim chaveBoletim;
    @ManyToOne
    @MapsId("alunoId")
    private Aluno aluno;
    @ManyToOne
    @MapsId("turmaId")
    private Turma turma;
    @ManyToOne
    @MapsId("disciplinaId")
    private Disciplina disciplina;
    private Double media;

    public Boletim(Aluno aluno, Double media) {
        this.aluno = aluno;
        this.media = media;
    }
}