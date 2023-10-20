package com.gerenciamento.gerenciamento.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boletim {

    @EmbeddedId
    private ChaveBoletim chaveBoletim;
    private Double media;
}