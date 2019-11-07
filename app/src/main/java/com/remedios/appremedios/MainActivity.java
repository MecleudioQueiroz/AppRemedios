package com.remedios.appremedios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void liberaco(View view){
        Intent intent = new Intent(MainActivity.this, Liberacao.class);
        startActivity(intent);
        }
 public  void cadastro(View view){
        Intent intent = new Intent(MainActivity.this,Cadastro.class);
        startActivity(intent);
        }

        public void relatorio(View view){
        Intent intent = new Intent(MainActivity.this,RelatorioActivity.class);
        startActivity(intent);
        }

}
