package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Turma;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TurmaDAO extends DAOPadrao<Turma, Integer>{
    @Override
    public Turma converter(ResultSet resultSet) throws SQLException {
        return new Turma(resultSet);
    }

    public TurmaDAO(String tabela) {
        super("turma");
    }

    @Override
    public void inserir(Turma obj) {

    }

    @Override
    public void atualizar(Turma obj) {

    }
}
