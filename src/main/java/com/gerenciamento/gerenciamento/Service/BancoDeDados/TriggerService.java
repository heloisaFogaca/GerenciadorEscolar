package com.gerenciamento.gerenciamento.Service.BancoDeDados;

import lombok.AllArgsConstructor;

import java.sql.*;
import java.util.Collection;

@AllArgsConstructor
public class TriggerService {

    private static final String BANCO_URL = "jdbc:mysql://localhost:3306/gerenciamentoescolar";
    private static final String USERNAME = "root";
    private static final String PASSSWORD = "root";

    public String createTriggerGerarMedia() {
        try (Connection conn = DriverManager.getConnection(BANCO_URL, USERNAME, PASSSWORD);
             Statement statement = conn.createStatement()) {
            String sql =
                    "create trigger gerarMediaBoletim \n" +
                            "before insert on boletim for each row\n" +
                            "begin\n" +
                            "    set new.media =  \n" +
                            "    (select avg(pr.nota) from prova pr join professor pf\n" +
                            "    on pr.professor_id = pf.id\n" +
                            "    where new.aluno_id = pr.aluno_id);\n" +
                            "END \n";
            statement.execute(sql);
            return "\nTrigger \"gerarMediaBoletim\" criado com sucesso.";

        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            return "\nFalha ao tentar criar o Trigger \"gerarMediaDisciplina(in id int)\" : " + throwables.getMessage();
        }
    }

    public String createTriggerAtualiazarBoletim() {
        try (Connection conn = DriverManager.getConnection(BANCO_URL, USERNAME, PASSSWORD);
             Statement statement = conn.createStatement()) {
            String sql =
                    "create trigger atualizarBoletim\n" +
                            "after insert on prova\n" +
                            "for each row\n" +
                            "begin\n" +
                            "    update boletim b set media = \n" +
                            "    (select avg(pr.nota) from prova pr join professor pf\n" +
                            "    on pr.professor_id = pf.id\n" +
                            "    where new.aluno_id = pr.aluno_id) \n" +
                            "    where b.aluno_id = new.aluno_id \n" +
                            "    and b.turma_id = \n" +
                            "    (select turma_id from aluno a \n" +
                            "    where a.id = new.aluno_id)\n" +
                            "    and b.disciplina_id = \n" +
                            "    (select disciplina_id from professor pf\n" +
                            "    where pf.id = new.professor_id);\n" +
                            "end \n";
            statement.execute(sql);
            return "\nTrigger \"atualizarBoletim\" criado com sucesso.";

        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            return "\nFalha ao tentar criar o Trigger \"gerarMediaDisciplina(in id int)\" : " + throwables.getMessage();
        }
    }

    //CHECKPOINT
}
