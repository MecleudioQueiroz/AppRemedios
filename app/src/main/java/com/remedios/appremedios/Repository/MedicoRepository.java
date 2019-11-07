package com.remedios.appremedios.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.remedios.appremedios.Model.MedicoModel;

public class MedicoRepository {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public MedicoRepository(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long Insert(MedicoModel medicoModel){
        ContentValues values = new ContentValues();
        values.put("nome",medicoModel.getNome());
        values.put("crm",medicoModel.getCrm());
        values.put("especificacao",medicoModel.getEspecificacao());
        return  banco.insert("medico",null,values);
    }
}
