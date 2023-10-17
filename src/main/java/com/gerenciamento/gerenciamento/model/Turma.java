package com.gerenciamento.gerenciamento.model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Turma {

    private  int id;
    private String nome;
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private static ArrayList<Turma> turmas = new ArrayList<>();

    public Turma(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Turma(ResultSet resultSet) {

    }


    public void adicionarProfessor(Professor usuario) {
        professores.add(usuario);
    }

    public void adicionarAluno(Aluno usuario) {
        alunos.add(usuario);
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public Turma buscarTurma() {
        for (Turma turma : getTurmas()) {
            if (turma.nome.equals(this.nome)) {
                return turma;
            }
        }
        return null;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarTurma() {
        turmas.add(this);
    }
}
