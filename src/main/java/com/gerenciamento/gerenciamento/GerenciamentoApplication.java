package com.gerenciamento.gerenciamento;

import com.gerenciamento.gerenciamento.Service.SecretarioService;
import com.gerenciamento.gerenciamento.Service.TurmaService;
import com.gerenciamento.gerenciamento.controller.TurmaController;
import com.gerenciamento.gerenciamento.model.Turma;
import com.gerenciamento.gerenciamento.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.sql.*;

@SpringBootApplication
public class GerenciamentoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(GerenciamentoApplication.class, args);

//		SecretarioService secretarioService = new SecretarioService();
//		TurmaService turma = new TurmaService();
//		TurmaRepository turmaRepository = null;
//		System.out.println(secretarioService.gerarBoletins(turma.buscarTurma(1)));
//	}
	}

}
