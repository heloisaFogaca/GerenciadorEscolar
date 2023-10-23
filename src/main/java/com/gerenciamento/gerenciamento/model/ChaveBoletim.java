package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ChaveBoletim {

    private Integer alunoId;
    private Integer disciplinaId;
    private Integer turmaId;

}