package com.remedios.appremedios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.remedios.appremedios.Model.UsuarioModel;

public class UsuarioActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference db;
    private UsuarioModel usuarioModel;
    private EditText edtNomeUsuario, edtSenha, edtRepidaSenha;
    private Button btnSalvarUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        firebaseDatabase = FirebaseDatabase.getInstance();
        db = firebaseDatabase.getReference("UsuarioModel");

        initViews();
        pegandoClienteDoBundle();
    }

    protected void initViews() {
        edtNomeUsuario = findViewById(R.id.edtNomeUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        edtRepidaSenha = findViewById(R.id.edtRepidaSenha);

        btnSalvarUsuario = findViewById(R.id.btnSalvarUsuario);
        btnSalvarUsuario.setOnClickListener(this);
    }

   @Override
   public void onClick(View view){
       if(view.getId() == R.id.btnSalvarUsuario) {
           initModel();
           SalvarCliente();
       }else{
           Remover();
       }
       finish();
   }

    private void SalvarCliente() {
        db.child(String.valueOf(usuarioModel.getId())).setValue(usuarioModel);
        showToast("Cliente Salvo com sucesso");
    }

    protected void initModel() {
        if(usuarioModel == null){
            usuarioModel = new UsuarioModel(edtNomeUsuario.getText().toString().trim(),
                    edtSenha.getText().toString().trim(),
                    edtRepidaSenha.getText().toString().trim());
        }else{

            usuarioModel = new UsuarioModel(usuarioModel.getId(),edtNomeUsuario.getText().toString().trim(),
                    edtSenha.getText().toString().trim(),
                    edtRepidaSenha.getText().toString().trim());
        }

    }

    private void showToast(String message) {
        Toast.makeText(this,
                message,
                Toast.LENGTH_LONG)
                .show();
    }

    private void pegandoClienteDoBundle() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            usuarioModel = (UsuarioModel) bundle.getSerializable("usuarioModel");
            if (usuarioModel != null) {
                edtNomeUsuario.setText(usuarioModel.getNome());
                edtSenha.setText(usuarioModel.getSenha());
                edtRepidaSenha.setText(usuarioModel.getRepitaSenha());
            }
        }
    }

    private void Remover(){
        db.child(String.valueOf(usuarioModel.getId())).removeValue();
        finish();
    }
}
