package com.remedios.appremedios.Model;

import java.io.Serializable;
import java.util.Random;

public class PacienteModel implements Serializable {
    private long id;
    private String nome;
    private String sobreNome;
    private String idade;
    private String telefone;
    private String endereco;

    public PacienteModel(String nome, String sobreNome, String idade, String telefone, String endereco) {
        this.id = new Random().nextInt(9999);
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public PacienteModel(long id, String nome, String sobreNome, String idade, String telefone, String endereco) {
        this.id = id;
        this.endereco = endereco;
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.sobreNome = sobreNome;
    }

    public long getId() {
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

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
