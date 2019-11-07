package com.remedios.appremedios.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    private static final String name = "banco.db";
    private static final int version = 2;

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table paciente(id interger primary key autoincrement, " +
                 "nome varchar(50), " +
                 "sobreNome varchar(50), " +
                 "idade varchar(2), " +
                 "telefone varchar(50), " +
                 "endereco varchar(50))");

        db.execSQL("create table medico(id interger primary key autoincrement, " +
                "nome varchar(50), " +
                "crm varchar(40), " +
                "especificacao varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
