package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.ChaveBoletim;
import com.gerenciamento.gerenciamento.repository.BoletimRepository;
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
