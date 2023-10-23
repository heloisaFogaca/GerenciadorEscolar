package com.gerenciamento.gerenciamento.Service;

import com.gerenciamento.gerenciamento.model.*;
import com.gerenciamento.gerenciamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SecretarioService {

    private UsuarioRepository usuarioRepository;
    private Secretario secretario;
    private BoletimService boletim;

    public List<Boletim> gerarBoletins (Turma turma){
        List<Boletim> boletins = new ArrayList<Boletim>();
        for(Aluno aluno : turma.getAlunos()){
            secretario.gerarBoletim(aluno);
        }
        return boletins;
    }
    public Boletim gerarBoletim(Aluno aluno){
        double somaMedias = 0.0;
        for(Prova prova : aluno.getProvas()){
            somaMedias += prova.getNota();
        }
        return new Boletim(aluno,somaMedias/aluno.getProvas().size());
    }

}
