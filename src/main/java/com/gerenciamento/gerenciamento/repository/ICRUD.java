package com.gerenciamento.gerenciamento.repository;

import java.util.Set;

public interface ICRUD<T, ID> {

    void inserir(T obj);

    T buscarUm(ID id);

    Set<T> buscarTodos();

    void deletar(ID id);

    void atualizar(T obj);


}
