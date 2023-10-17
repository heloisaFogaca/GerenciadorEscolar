package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Secretario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SecretarioDAO extends DAOPadrao<Secretario, Integer> {

    @Override
    public Secretario converter(ResultSet resultSet) throws SQLException {
        return new Secretario(resultSet);
    }

    public SecretarioDAO(String tabela) {
        super("secretario");
    }

    @Override
    public void inserir(Secretario obj) {

    }

    @Override
    public void atualizar(Secretario obj) {

    }
}
