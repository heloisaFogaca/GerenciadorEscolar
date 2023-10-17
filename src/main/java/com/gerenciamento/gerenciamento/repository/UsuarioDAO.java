package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends DAOPadrao<Usuario, Integer> {
    @Override
    public Usuario converter(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet);
    }

    public UsuarioDAO(String tabela) {
        super("usuario");
    }
    @Override
    public void inserir(Usuario obj) {
        comandoSQL = "INSERT INTO usuario VALUES(?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(comandoSQL)){

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
    @Override
    public void atualizar(Usuario obj) {

    }
}
