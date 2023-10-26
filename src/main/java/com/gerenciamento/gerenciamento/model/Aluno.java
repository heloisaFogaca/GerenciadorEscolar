package com.gerenciamento.gerenciamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name="id")
public class Aluno extends Usuario {

    @ManyToOne
    private Turma turma;
    @OneToMany(mappedBy="aluno")
    @JsonIgnore
    private List<Prova> provas;

    public Aluno(int idAluno) {
    }
}
