package com.gerenciamento.gerenciamento.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {

    int id;
    private String nome;
    private String endereco;
    private int idade;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario(int id, String nome, int idade, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
    }
    public Usuario(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.nome = resultSet.getString("nome");
        this.idade = resultSet.getInt("idade");
        this.endereco = resultSet.getString("endereco");
    }
    public Usuario (int id){
        this.id= id;
    }


    public Usuario buscarUsuario(Usuario usuarioBusca){
        System.out.println(usuarios);
        for (Usuario usuario: usuarios){
            if (usuario.nome.equals(usuarioBusca.nome)){
                if (usuario.endereco.equals(usuarioBusca.endereco)){
                    if (usuario.idade == usuarioBusca.idade){
                        return usuario;
                    }
                }
            }
        }

      return null;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public String menu(){
        return "";
    }

    public void setUsuarios() {
        usuarios.add(this);
    }
}
