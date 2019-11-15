package com.remedios.appremedios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.remedios.appremedios.Model.PacienteModel;

public class Paciente extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference db;
    private PacienteModel pacienteModel;
    private EditText edtNome,edtSobreNome,edtIdade,edtTelefone,edtEndereco;
    private Button btnSalvarPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        firebaseDatabase = FirebaseDatabase.getInstance();
        db = firebaseDatabase.getReference("PacienteModel");

        initViews();
        pegandoClienteDoBundle();
    }

    protected void initViews() {
        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEndereco = findViewById(R.id.edtEndereco);
        edtSobreNome = findViewById(R.id.edtSobreNome);
        edtIdade = findViewById(R.id.edtIdade);

        btnSalvarPaciente = findViewById(R.id.btnSalvarPaciente);
        btnSalvarPaciente.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnSalvarPaciente) {
            initModel();
            SalvarPaciente();
        }else{
            Remover();
        }
        finish();
    }


    private void SalvarPaciente() {
        db.child(String.valueOf(pacienteModel.getId())).setValue(pacienteModel);
        showToast("Paciente Salvo com sucesso");
    }

    protected void initModel() {
        if(pacienteModel == null){
            pacienteModel = new PacienteModel(edtNome.getText().toString().trim(),
                    edtSobreNome.getText().toString().trim(),
                    edtIdade.getText().toString().trim(),
                    edtTelefone.getText().toString().trim(),
                    edtEndereco.getText().toString().trim());
        }
        else{
            pacienteModel = new PacienteModel(pacienteModel.getId(),edtNome.getText().toString().trim(),
                    edtSobreNome.getText().toString().trim(),
                    edtIdade.getText().toString().trim(),
                    edtTelefone.getText().toString().trim(),
                    edtEndereco.getText().toString().trim());
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
            pacienteModel = (PacienteModel) bundle.getSerializable("pacienteModel");
            if (pacienteModel != null) {
                edtNome.setText(pacienteModel.getNome());
                edtSobreNome.setText(pacienteModel.getTelefone());
                edtTelefone.setText(pacienteModel.getEndereco());
                edtIdade.setText(pacienteModel.getTelefone());
                edtEndereco.setText(pacienteModel.getEndereco());
            }
        }
    }

    private void Remover(){
        db.child(String.valueOf(pacienteModel.getId())).removeValue();
        finish();
    }

}
