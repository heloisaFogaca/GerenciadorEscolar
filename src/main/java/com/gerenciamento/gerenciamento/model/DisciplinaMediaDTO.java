package com.gerenciamento.gerenciamento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaMediaDTO {

//    private Aluno aluno;
    private Integer aluno_id;
    private String aluno_nome;
    private Double media;
    private Integer turma_id;

}
