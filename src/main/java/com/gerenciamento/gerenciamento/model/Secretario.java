package com.gerenciamento.gerenciamento.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Secretario extends Usuario {

    private int quantidadeDeBoletins;

    public Secretario(int id, String nome, String endereco, int idade){
        super(id, nome, idade, endereco);
        this.quantidadeDeBoletins = 0;
    }
    public Secretario(ResultSet resultSet) throws SQLException {
        super(resultSet);
    }

    public Secretario(int id){
        super(id);
    }

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
