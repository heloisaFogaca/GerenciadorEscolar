package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.Disciplina;
import com.gerenciamento.gerenciamento.repository.BoletimRepository;
import com.gerenciamento.gerenciamento.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class BoletimService {

        private BoletimRepository boletimRepository;

        public void salvar(Boletim boletim) {
            boletimRepository.save(boletim);
        }

        public Boletim buscar(Integer id) {
            return boletimRepository.findById(id).get();
        }

        public Collection buscarTodos() {
            return boletimRepository.findAll();
        }

        public void remover(Integer id) {
            boletimRepository.deleteById(id);
        }

}
