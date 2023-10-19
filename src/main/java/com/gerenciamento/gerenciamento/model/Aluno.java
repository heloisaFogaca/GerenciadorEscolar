package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name="id")
public class Aluno extends Usuario {

    @ManyToOne
    private Turma turma;

    @Override
    public String menu() {
        return """
                1 - Calcular média
                0 - Logout
                """;
    }
}
