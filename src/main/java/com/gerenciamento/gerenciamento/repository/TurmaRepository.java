package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Turma;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
