package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name="id")
public class Aluno extends Usuario {

    @ManyToOne
    private Turma turma;

}
