package com.gerenciamento.gerenciamento.Service.BancoDeDados;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Collection;

//@Service
@AllArgsConstructor
public class ProcedureService {

    private static final String BANCO_URL = "jdbc:mysql://localhost:3306/gerenciamentoescolar";
    private static final String USERNAME = "root";
    private static final String PASSSWORD = "root";


    public String createGerarMediaDisciplina() {
        try (Connection conn = DriverManager.getConnection(BANCO_URL, USERNAME, PASSSWORD);
             Statement statement = conn.createStatement()) {
            String sql =
                    "CREATE PROCEDURE gerarMediaDisciplina(in id int)\n" +
                            "BEGIN\n" +
                            "select avg(pr.nota) as media from prova pr\n" +
                            "where pr.id = id\n" +
                            "group by pr.id;\n" +
                            //filtra pelo professor pois professor possui apenas uma disciplina
                            "END \n" ;
            statement.execute(sql);
            return "Procedure \"gerarMediaDisciplina(in id int)\" criada com sucesso.";

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "Falha ao tentar criar a procedure \"gerarMediaDisciplina(in id int)\"";
        }
    }

    //CHECKPOINT

    public static Collection<Double> callGerarMediaDisciplina(int id) throws SQLException {
        //mudar para retornar a media de todas as disciplinas a acima a mesma coisa (talvez mudar estrutura do BD pois aluno pode ter varia disciplinas[a verificar])

        try (Connection conn = DriverManager.getConnection(BANCO_URL, USERNAME, PASSSWORD);
             CallableStatement statement = conn.prepareCall("{call gerarMediaDisciplina(1)}");) {
            //mudar para prepared statement e receber por parametro

            boolean hasResults = statement.execute();

            if (hasResults) {
                ResultSet resultSet = statement.getResultSet();

                if (resultSet.next()) {
                    double media = resultSet.getDouble("media");
                    System.out.println("A média das notas da disciplina é: " + media);
                }
                resultSet.close();
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
