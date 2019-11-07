package com.remedios.appremedios.Model;

public class UsuarioModel {
    private int id;
    private String nome;
    private String senha;
    private String repitaSenha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepitaSenha() {
        return repitaSenha;
    }

    public void setRepitaSenha(String repitaSenha) {
        this.repitaSenha = repitaSenha;
    }
}
