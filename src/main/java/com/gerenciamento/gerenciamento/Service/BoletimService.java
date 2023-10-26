package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.Service.BancoDeDados.ProcedureService;
import com.gerenciamento.gerenciamento.model.*;
import com.gerenciamento.gerenciamento.repository.BoletimRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Collection;

@AllArgsConstructor
@Service
public class BoletimService {


    private static final String BANCO_URL = "jdbc:mysql://localhost:3306/gerenciamentoescolar";
    private static final String USERNAME = "root";
    private static final String PASSSWORD = "root";

        private final BoletimRepository boletimRepository;
        TurmaService turmaService;
        DisciplinaService disciplinaService;
        UsuarioService usuarioService;

        public void salvar(Boletim boletim) {
            boletimRepository.save(boletim);
        }

        private BoletimRepository boletimRepository;
        private ProcedureService procedureService;
        private TurmaService turmaService;
        private ProfessorService professorService;

        public void salvar(Integer turma_id) {

            for(Aluno aluno : turmaService.buscarTurma(turma_id).getAlunos()){

                for(Professor professor : professorService.buscarTodos()){
                    if(professor.getTurma().getId() == turma_id ){
                        procedureService.gerarBoletimDisciplina(turma_id, professor.getDisciplina().getId() ,aluno.getId());
                    }
                }

            }



//            boletimRepository.save(gerarBoletim(aluno));

        }

        public Boletim buscar(ChaveBoletim chaveBoletim) {
            return boletimRepository.findById(chaveBoletim).get();
        }

        public Collection buscarTodos() {
            return boletimRepository.findAll();
        }

        public void remover(ChaveBoletim chaveBoletim) {
            boletimRepository.deleteById(chaveBoletim);
        }


}


