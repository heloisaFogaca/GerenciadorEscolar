package com.gerenciamento.gerenciamento.repository;


import com.gerenciamento.gerenciamento.model.Prova;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvaDAO extends DAOPadrao<Prova, Integer>{


    @Override
    public Prova converter(ResultSet resultSet) throws SQLException {
        return new Prova(resultSet);
    }

    public ProvaDAO(String tabela) {
        super("prova");
    }

    @Override
    public void inserir(Prova obj) {

    }

    @Override
    public void atualizar(Prova obj) {

    }
}
