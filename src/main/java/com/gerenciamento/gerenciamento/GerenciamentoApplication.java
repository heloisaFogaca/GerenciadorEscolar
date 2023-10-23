package com.gerenciamento.gerenciamento;

import com.gerenciamento.gerenciamento.Service.BoletimService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class GerenciamentoApplication {

	public static void main(String[] args) throws SQLException {

//		chamaMediaDisciplinas();
		SpringApplication.run(GerenciamentoApplication.class, args);
	}

	public static void chamaMediaDisciplinas() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciamentoescolar", "root", "root");
		CallableStatement statement = conn.prepareCall("{call gerarMediaDisciplina(1)}");
		boolean hasResults = statement.execute();

		if (hasResults) {
			ResultSet resultSet = statement.getResultSet();

			if (resultSet.next()) {
				double media = resultSet.getDouble("media");
				System.out.println("A média das notas da disciplina é: " + media);
			}
			resultSet.close();
		}

		statement.close();
		conn.close();
	}
}

//	public static void chamaMediaDisciplinas() throws SQLException {
//		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciamentoescolar", "root", "root");
//			 Statement statement = conn.createStatement()) {
//			String sql = "DELIMITER $$\n" +
//					"CREATE PROCEDURE gerarMediaDisciplina(in id int)\n" +
//					"BEGIN\n" +
//					"    select avg(pr.nota) \"media\" from prova pr\n" +
//					"    where pr.id = id\n" +
//					"    group by pr.id;\n" +
//					"    -- filtra pelo professor pois professor possui apenas uma disciplina\n" +
//					"END $$";
//			statement.execute(sql);
//			System.out.println("Procedure criada com sucesso.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
