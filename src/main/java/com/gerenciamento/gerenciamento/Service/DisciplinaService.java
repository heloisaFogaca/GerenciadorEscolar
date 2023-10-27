package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Disciplina;
import com.gerenciamento.gerenciamento.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository;

    public void salvar(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    public Disciplina buscarDisciplina(Integer id) {
        return disciplinaRepository.findById(id).get();
    }

    public Collection buscarTodos() {
        return disciplinaRepository.findAll();
    }

    public void remover(Integer id) {
        disciplinaRepository.deleteById(id);
    }


}
