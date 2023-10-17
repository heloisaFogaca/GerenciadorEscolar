package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Aluno;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO extends DAOPadrao<Aluno, Integer> {
    @Override
    public Aluno converter(ResultSet resultSet) throws SQLException {
        return new Aluno(resultSet);
    }

    public AlunoDAO(String tabela) {
        super("aluno");
    }

    @Override
    public void inserir(Aluno obj) {

    }

    @Override
    public void atualizar(Aluno obj) {

    }
}
