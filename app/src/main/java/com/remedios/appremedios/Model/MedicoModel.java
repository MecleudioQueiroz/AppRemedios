package com.remedios.appremedios.Model;

import java.io.Serializable;
import java.util.Random;

public class MedicoModel implements Serializable {
    private long id;
    private String nome;
    private String crm;
    private String especificacao;

    public MedicoModel(String nome, String crm, String especificacao) {
        this.id = new Random().nextInt(9999);
        this.nome = nome;
        this.crm = crm;
        this.especificacao = especificacao;
    }

    public MedicoModel(long id, String nome, String crm, String especificacao) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especificacao = especificacao;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }
}
