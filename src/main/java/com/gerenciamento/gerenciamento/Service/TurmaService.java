package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Disciplina;
import com.gerenciamento.gerenciamento.model.Turma;
import com.gerenciamento.gerenciamento.repository.DisciplinaRepository;
import com.gerenciamento.gerenciamento.repository.TurmaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class TurmaService {

    private TurmaRepository turmaRepository;

    public void salvar(Turma turma) {
        turmaRepository.save(turma);
    }

    public Turma buscarTurma(Integer id) {
        return turmaRepository.findById(id).get();
    }

    public Collection buscarTodos() {
        return turmaRepository.findAll();
    }

    public void remover(Integer id) {
        turmaRepository.deleteById(id);
    }


}