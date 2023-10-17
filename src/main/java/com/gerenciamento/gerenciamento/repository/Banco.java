package com.gerenciamento.gerenciamento.repository;

import com.gerenciamento.gerenciamento.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;

public class Banco {
    private  static final String URL_BANCO = "jdbc:mysql://localhost3306/gerenciamentoEscolar";
    private static final  String USERNAME = "root";
    private static final String SENHA = "root";

    public static Connection conectar(){
        try {
            return DriverManager.getConnection(URL_BANCO, USERNAME, SENHA);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
