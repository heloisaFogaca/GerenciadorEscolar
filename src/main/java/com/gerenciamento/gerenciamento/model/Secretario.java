package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "secretario")
@PrimaryKeyJoinColumn(name="id")
public class Secretario extends Usuario {
    private int quantidadeDeBoletins;

    public Boletim gerarBoletim(Aluno aluno){
        double somaMedias = 0.0;
            for(Prova prova : aluno.getProvas()){
                somaMedias += prova.getNota();
            }
            return new Boletim(aluno,somaMedias/aluno.getProvas().size());
    }
}
