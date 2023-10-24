package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.Professor;
import com.gerenciamento.gerenciamento.model.Secretario;
import com.gerenciamento.gerenciamento.repository.ProfessorRepository;
import com.gerenciamento.gerenciamento.repository.SecretarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class SecretarioService {

    private SecretarioRepository secretarioRepository;

    public void salvar(Secretario secretario) {
        secretarioRepository.save(secretario);
    }

    public Secretario buscarUsuario(Integer id){
        return secretarioRepository.findById(id).get();
    }

    public Collection<Secretario> buscarTodos(){
        return secretarioRepository.findAll();
    }

    public void remover(Integer id){
        secretarioRepository.deleteById(id);
    }

}
