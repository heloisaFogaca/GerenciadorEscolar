package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Disciplina;
import com.gerenciamento.gerenciamento.model.Prova;
import com.gerenciamento.gerenciamento.model.Turma;
import com.gerenciamento.gerenciamento.repository.DisciplinaRepository;
import com.gerenciamento.gerenciamento.repository.ProvaRepository;
import com.gerenciamento.gerenciamento.repository.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class ProvaService {

    private ProvaRepository provaRepository;

    public void salvar(Prova prova) {
        provaRepository.save(prova);
    }

    public Prova buscarProva(Integer id) {
       return provaRepository.findById(id).get();
    }

    public Collection buscarTodos() {
        return provaRepository.findAll();
    }

    public void remover(Integer id) {
        provaRepository.deleteById(id);
    }


}