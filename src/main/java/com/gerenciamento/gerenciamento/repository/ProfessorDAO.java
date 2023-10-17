package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Professor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO extends DAOPadrao<Professor, Integer> {
    @Override
    public Professor converter(ResultSet resultSet) throws SQLException {
        return null;
    }

    public ProfessorDAO(String tabela) {
        super("professor");
    }

    @Override
    public void inserir(Professor obj) {

    }

    @Override
    public void atualizar(Professor obj) {

    }
}
