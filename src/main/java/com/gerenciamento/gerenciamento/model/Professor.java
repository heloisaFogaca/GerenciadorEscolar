package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name="id")
public class Professor extends Usuario {
    @ManyToOne
    private Turma turma;
    @ManyToOne
    private Disciplina disciplina;

}
