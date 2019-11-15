package com.remedios.appremedios.Model;

import java.io.Serializable;
import java.util.Random;

public class RemedioModel implements Serializable {
    private int id;
    private String nomeRemedio;
    private String laboratorio;
    private String descricao;
    private String classeTerapeuta;
    private String generico;
    private String similar;
    private String etico;

    public RemedioModel(String nomeRemedio, String laboratorio, String descricao, String classeTerapeuta, String generico, String similar, String etico) {
        this.id = new Random().nextInt(9999);
        this.nomeRemedio = nomeRemedio;
        this.laboratorio = laboratorio;
        this.descricao = descricao;
        this.classeTerapeuta = classeTerapeuta;
        this.generico = generico;
        this.similar = similar;
        this.etico = etico;
    }

    public RemedioModel(int id,String nomeRemedio, String laboratorio, String descricao, String classeTerapeuta, String generico, String similar, String etico) {
        this.id = id;
        this.nomeRemedio = nomeRemedio;
        this.laboratorio = laboratorio;
        this.descricao = descricao;
        this.classeTerapeuta = classeTerapeuta;
        this.generico = generico;
        this.similar = similar;
        this.etico = etico;
    }

    public RemedioModel() {
    }

    public String getGenerico() {
        return generico;
    }

    public void setGenerico(String generico) {
        this.generico = generico;
    }

    public String getSimilar() {
        return similar;
    }

    public void setSimilar(String similar) {
        this.similar = similar;
    }

    public String getEtico() {
        return etico;
    }

    public void setEtico(String etico) {
        this.etico = etico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRemedio() {
        return nomeRemedio;
    }

    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getClasseTerapeuta() {
        return classeTerapeuta;
    }

    public void setClasseTerapeuta(String classeTerapeuta) {
        this.classeTerapeuta = classeTerapeuta;
    }

}
