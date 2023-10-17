package com.gerenciamento.gerenciamento.repository;

import java.sql.*;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class DAOPadrao<T, ID> implements ICRUD<T, Integer> {

    protected Connection connection;
    protected String comandoSQL;

    private String tabela;

    public abstract T converter(ResultSet resultSet) throws SQLException;

    public DAOPadrao(String tabela) {
        this.connection = Banco.conectar();
        this.tabela = tabela;
    }

    public void close() throws Exception {
        this.connection.close();
    }

    @Override
    public T buscarUm(Integer id) {
        comandoSQL = "SELECT * FROM " + tabela + " WHERE id= ?;";
        try (PreparedStatement statement = connection.prepareStatement(comandoSQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return (converter(resultSet));
            }
            throw new NoSuchElementException();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<T> buscarTodos() {
        comandoSQL = "SELECT * FROM " + tabela + ";";
        try (PreparedStatement statement = connection.prepareStatement(comandoSQL)) {
            ResultSet resultSet = statement.executeQuery();
            Set<T> lista = new HashSet<>();
            while (resultSet.next()) {
                lista.add(converter(resultSet));
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar(Integer id) {
        comandoSQL = "DELETE FROM " + tabela + " WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(comandoSQL)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
