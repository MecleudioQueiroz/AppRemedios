package com.remedios.appremedios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void paciente(View view){
        Intent intent = new Intent(Cadastro.this,Paciente.class);
        startActivity(intent);
    }

    public void medico(View view){
        Intent intent = new Intent(Cadastro.this,Medico.class);
        startActivity(intent);
    }

    public void remedio(View view){
        Intent intent = new Intent(Cadastro.this,Remedio.class);
        startActivity(intent);
    }

    public void usuario(View view){
        Intent intent = new Intent(Cadastro.this,UsuarioActivity.class);
        startActivity(intent);
    }
}
