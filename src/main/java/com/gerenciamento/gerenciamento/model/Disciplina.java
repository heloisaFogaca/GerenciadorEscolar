package com.gerenciamento.gerenciamento.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Disciplina {
    private String nome;
    private int id;
    private double cargaHoraria;

    public Disciplina(String nome, int id, double cargaHoraria){
        this.nome = nome;
        this.id = id;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.nome = resultSet.getString("nome");
        this.cargaHoraria = resultSet.getDouble("cargaHoraria");
    }

    public String getNome() {
        return nome;
    }
}
