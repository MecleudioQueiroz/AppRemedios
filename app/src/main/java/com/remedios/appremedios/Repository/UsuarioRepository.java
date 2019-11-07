package com.remedios.appremedios.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioRepository {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public UsuarioRepository (Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
}
