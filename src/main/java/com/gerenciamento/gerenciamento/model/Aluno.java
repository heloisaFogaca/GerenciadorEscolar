package com.gerenciamento.gerenciamento.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Aluno extends Usuario {
    private Turma turma;
    private ArrayList<Prova> provas = new ArrayList<>();


    public Aluno(int id, String nome, String endereco, int idade, Turma turma) {
        super(id, nome, idade, endereco);
        this.turma = turma;
    }

    public Aluno(ResultSet resultSet) throws SQLException {
        super(resultSet);
        this.id = resultSet.getInt("id");
    }

    public Aluno(int id){
        super(id);
    }

    //ve a media do aluno em todas as suas disciplinas
    public void calcularMedia() {

    }

    public void adicionarProva(Prova prova) {
        this.provas.add(prova);
    }

    @Override
    public String menu() {
        return """
                1 - Calcular média
                0 - Logout
                """;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public ArrayList<Prova> getProvas() {
        return provas;
    }

    public Turma getTurma() {
        return turma;
    }
}
