package com.remedios.appremedios.Model;

import java.io.Serializable;
import java.util.Random;

public class UsuarioModel implements Serializable {
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

    public UsuarioModel(String nome, String senha, String repitaSenha) {
        this.id = new Random().nextInt(9999);
        this.nome = nome;
        this.senha = senha;
        this.repitaSenha = repitaSenha;
    }

    public UsuarioModel(int id, String nome, String senha, String repitaSenha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.repitaSenha = repitaSenha;
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
