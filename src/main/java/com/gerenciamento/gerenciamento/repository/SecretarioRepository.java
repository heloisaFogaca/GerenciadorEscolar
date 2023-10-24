package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Secretario;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface SecretarioRepository extends JpaRepository<Secretario, Integer> {
}
