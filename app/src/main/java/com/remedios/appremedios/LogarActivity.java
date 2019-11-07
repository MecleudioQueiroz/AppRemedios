package com.remedios.appremedios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logar);
    }

    public void cadastrarUsuario(View view){
        Intent intent = new Intent(LogarActivity.this, UsuarioActivity.class);
        startActivity(intent);
    }

    public void telaPrincipal(View view){
        Intent intent = new Intent(LogarActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
