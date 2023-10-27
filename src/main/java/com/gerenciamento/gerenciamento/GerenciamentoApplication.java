package com.gerenciamento.gerenciamento;

import com.gerenciamento.gerenciamento.Service.*;
import com.gerenciamento.gerenciamento.Service.BancoDeDados.ProcedureService;
import com.gerenciamento.gerenciamento.Service.BancoDeDados.TriggerService;
import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.Disciplina;
import com.gerenciamento.gerenciamento.model.Turma;
import com.gerenciamento.gerenciamento.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
@AllArgsConstructor
public class GerenciamentoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(GerenciamentoApplication.class, args);
		ProcedureService procedureService = new ProcedureService();
		TriggerService triggerService = new TriggerService();

		System.out.println(procedureService.criarGerarBoletimDisciplina());
		System.out.println(procedureService.createGerarMediaDisciplina());
		procedureService.callGerarMediaDisciplina(1);
		System.out.println(triggerService.createTriggerGerarMedia());
		System.out.println(triggerService.createTriggerAtualiazarBoletim());

	}

}

