package com.remedios.appremedios.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.remedios.appremedios.Model.PacienteModel;
import com.remedios.appremedios.Paciente;

public class PacienteRepository {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public PacienteRepository(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public Long insert(PacienteModel paciente){
        ContentValues values = new ContentValues();
        values.put("nome", paciente.getNome());
        values.put("sobreNome",paciente.getSobreNome());
        values.put("idade",paciente.getIdade());
        values.put("telefone",paciente.getTelefone());
        values.put("endereco",paciente.getEndereco());
       return banco.insert("paciente",null,values);
    }
}
