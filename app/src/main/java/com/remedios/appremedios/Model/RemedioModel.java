package com.remedios.appremedios.Model;

public class RemedioModel {
    private int id;
    private String nomeRemedio;
    private String laboratorio;
    private String descricao;
    private String classeTerapeuta;
    private String tiposMedicamentos;

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

    public String getTiposMedicamentos() {
        return tiposMedicamentos;
    }

    public void setTiposMedicamentos(String tiposMedicamentos) {
        this.tiposMedicamentos = tiposMedicamentos;
    }
}
