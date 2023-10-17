package com.gerenciamento.gerenciamento.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Prova {

    private int id;
    private Professor professor;
    private double nota;
    private Aluno aluno;

    public Prova(int id, double nota, Professor professor, Aluno aluno) {
        this.id = id;
        this.professor = professor;
        this.nota = nota;
        this.aluno = aluno;
    }
    public Prova(ResultSet resultSet) throws SQLException {
        this.id= resultSet.getInt("id");
        this.nota = resultSet.getDouble("nota");
        int idProfessor = resultSet.getInt("id_professor");
        if (idProfessor != 0 ){
            this.professor = new Professor(idProfessor);
        }
        int idAluno =  resultSet.getInt("id_aluno");
        if (idAluno != 0){
            this.aluno = new Aluno(idAluno);
        }
    }

    public Professor getProfessor() {
        return professor;
    }

    public double getNota() {
        return nota;
    }
}
