package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    @Override
    public String menu() {
        return """
                1 - Ver média de alunos
                2 - Gerar nova nota
                0 - Logout
                """;
    }
}
