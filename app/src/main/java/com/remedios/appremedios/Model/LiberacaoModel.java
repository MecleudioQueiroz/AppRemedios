package com.remedios.appremedios.Model;

public class LiberacaoModel {
    private int Id;
    private String Descricao;
    private MedicoModel medico;
    private PacienteModel paciente;
    private RemedioModel remedio;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
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
