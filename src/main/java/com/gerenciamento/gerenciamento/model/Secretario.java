package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "secretario")
@PrimaryKeyJoinColumn(name="id")
public class Secretario extends Usuario {
    private int quantidadeDeBoletins;

    @Override
    public String menu() {
        return """
                1 - Gerar boletim
                2 - Alocar usuarios à turmas
                3 - Atribuir disciplina
                4 - Criar Turma.
                0 - Logout
                """;
    }
}
