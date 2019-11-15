package com.remedios.appremedios.Model;

import java.io.Serializable;
import java.util.Random;

public class LiberacaoModel implements Serializable {
    private int Id;
    private MedicoModel medico;
    private PacienteModel paciente;
    private RemedioModel remedio;

    public LiberacaoModel(String nome, String paciente, String remedio) {
        this.Id = new Random().nextInt(9999);
        this.medico = medico;
        this.paciente = paciente;
        this.remedio = remedio;
    }

    public LiberacaoModel(long id, String nome, String crm, String especificacao) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especificacao = especificacao;
    }

    public LiberacaoModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    public RemedioModel getRemedio() {
        return remedio;
    }

    public void setRemedio(RemedioModel remedio) {
        this.remedio = remedio;
    }
}
