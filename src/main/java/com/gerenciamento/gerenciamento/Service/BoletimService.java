package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.Service.BancoDeDados.ProcedureService;
import com.gerenciamento.gerenciamento.model.*;
import com.gerenciamento.gerenciamento.repository.BoletimRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class BoletimService {

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

        public Boletim gerarBoletim(Aluno aluno){
        double somaMedias = 0.0;
        for(Prova prova : aluno.getProvas()){
            somaMedias += prova.getNota();
        }
        return new Boletim(aluno,somaMedias/aluno.getProvas().size());
    }

}


