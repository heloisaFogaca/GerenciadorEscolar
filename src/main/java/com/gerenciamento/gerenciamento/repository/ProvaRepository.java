package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Integer> {
}
