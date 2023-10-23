package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.ChaveBoletim;
import com.gerenciamento.gerenciamento.model.Prova;
import com.gerenciamento.gerenciamento.repository.BoletimRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class BoletimService {

        private BoletimRepository boletimRepository;

        public void salvar(Aluno aluno) {
            boletimRepository.save(gerarBoletim(aluno));
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


