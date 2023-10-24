package com.gerenciamento.gerenciamento;

import com.gerenciamento.gerenciamento.Service.BancoDeDados.ProcedureService;
import com.gerenciamento.gerenciamento.Service.BoletimService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class GerenciamentoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(GerenciamentoApplication.class, args);

		ProcedureService procedureService = new ProcedureService();

		System.out.println(procedureService.createGerarMediaDisciplina());
		System.out.println(procedureService.callGerarMediaDisciplina(1));
	}

}

