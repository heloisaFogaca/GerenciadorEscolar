package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Aluno;
import com.gerenciamento.gerenciamento.model.Usuario;
import com.gerenciamento.gerenciamento.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;

@AllArgsConstructor
@Service
public class AlunoService {

        private final AlunoRepository alunoRepository;

        public void salvar(Aluno aluno) {
            alunoRepository.save(aluno);
        }

        public Aluno buscarUsuario(Integer id) {
            return alunoRepository.findById(id).get();
        }

        public Collection<Aluno> buscarTodos() {
            return alunoRepository.findAll();
        }

        public void remover(Integer id) {
            alunoRepository.deleteById(id);
        }
}
