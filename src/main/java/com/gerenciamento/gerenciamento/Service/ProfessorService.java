package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Professor;
import com.gerenciamento.gerenciamento.model.Usuario;
import com.gerenciamento.gerenciamento.repository.AlunoRepository;
import com.gerenciamento.gerenciamento.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;


@Service
@AllArgsConstructor
public class ProfessorService {

    private ProfessorRepository professorRepository;

    public void salvar(Professor professor) {
        professorRepository.save(professor);
    }

    public Professor buscarUsuario(Integer id){
        return professorRepository.findById(id).get();
    }

    public Collection<Professor> buscarTodos(){
        return professorRepository.findAll();
    }

    public void remover(Integer id){
        professorRepository.deleteById(id);
    }

}
