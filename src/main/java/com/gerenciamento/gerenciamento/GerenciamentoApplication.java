package com.gerenciamento.gerenciamento;

import com.gerenciamento.gerenciamento.Service.*;
import com.gerenciamento.gerenciamento.Service.BancoDeDados.ProcedureService;
import com.gerenciamento.gerenciamento.Service.BancoDeDados.TriggerService;
import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.Disciplina;
import com.gerenciamento.gerenciamento.model.Turma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class GerenciamentoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(GerenciamentoApplication.class, args);

		ProcedureService procedureService = new ProcedureService();
		TriggerService triggerService = new TriggerService();

		System.out.println(procedureService.createGerarMediaDisciplina());
		System.out.println(triggerService.createTriggerGerarMedia());
		System.out.println(triggerService.createTriggerAtualiazarBoletim());
	}

}

