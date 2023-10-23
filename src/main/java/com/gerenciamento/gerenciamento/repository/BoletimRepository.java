package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Boletim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletimRepository extends JpaRepository<Boletim, Integer> {
}
