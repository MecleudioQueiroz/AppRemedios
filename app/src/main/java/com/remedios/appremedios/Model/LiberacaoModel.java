package com.remedios.appremedios.Model;

import java.io.Serializable;
import java.sql.Time;

public class LiberacaoModel implements Serializable {
    private int Id;
    private String medico;
    private String paciente;
    private String remedio;
    private Time Data;

    public LiberacaoModel(int i, String remedio) {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getRemedio() {
        return remedio;
    }

    public void setRemedio(String remedio) {
        this.remedio = remedio;
    }

    public Time getData() {
        return Data;
    }

    public void setData(Time data) {
        Data = data;
    }
}
