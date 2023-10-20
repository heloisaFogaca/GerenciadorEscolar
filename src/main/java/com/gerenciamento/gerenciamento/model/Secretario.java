package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "secretario")
@PrimaryKeyJoinColumn(name="id")
public class Secretario extends Usuario {
    private int quantidadeDeBoletins;
}
