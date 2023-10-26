package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.ChaveBoletim;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletimRepository extends JpaRepository<Boletim, ChaveBoletim> {
}
