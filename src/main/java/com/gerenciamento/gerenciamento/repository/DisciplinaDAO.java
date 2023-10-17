package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Disciplina;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DisciplinaDAO extends DAOPadrao<Disciplina, Integer> {
    @Override
    public Disciplina converter(ResultSet resultSet) throws SQLException {
        return new Disciplina(resultSet);
    }

    public DisciplinaDAO(String tabela) {
        super("disciplina");
    }

    @Override
    public void inserir(Disciplina obj) {

    }

    @Override
    public void atualizar(Disciplina obj) {

    }
}
