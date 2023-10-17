package com.gerenciamento.gerenciamento.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Professor extends Usuario {

    private Turma turma;
    private Disciplina disciplina;

//    id_usuario int not null primary key,
//    id_disciplina int not null,
//    foreign key (id_usuario) references usuario(id),
//    foreign key (id_disciplina) references disciplina(id)
    public Professor(int id, String nome, String endereco, int idade, Turma turma, Disciplina disciplina) {
        super(id, nome, idade, endereco);
        this.disciplina = disciplina;
        this.turma = turma;
    }

    public Professor(ResultSet resultSet) throws SQLException {
        super(resultSet);
    }

    public Professor(int idProfessor) {
        super(idProfessor);
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public ArrayList<Aluno> buscarAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        for (Usuario usuario : getUsuarios()) {
            if (usuario instanceof Aluno) {
                if (((Aluno) usuario).getTurma().equals(this.turma)) {
                    alunos.add((Aluno) usuario);
                }
            }
        }

        return alunos;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String menu() {
        return """
                1 - Ver média de alunos
                2 - Gerar nova nota
                0 - Logout
                """;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
