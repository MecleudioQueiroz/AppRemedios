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
import com.remedios.appremedios.Model.MedicoModel;
import com.remedios.appremedios.Model.PacienteModel;

public class MedicoActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference db;
    private MedicoModel medicoModel;
    private EditText edtNomeMedico,edtCrmMedico,edtEspecificacaoMedico;
    private Button btnCadastrarMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico);

        firebaseDatabase = FirebaseDatabase.getInstance();
        db = firebaseDatabase.getReference("MedicoModel");

        initViews();
        pegandoClienteDoBundle();
    }

    protected void initViews() {
        edtNomeMedico = findViewById(R.id.edtNomeMedico);
        edtCrmMedico = findViewById(R.id.edtCrmMedico);
        edtEspecificacaoMedico = findViewById(R.id.edtEspecificacaoMedico);

        btnCadastrarMedico = findViewById(R.id.btnCadastrarMedico);
        btnCadastrarMedico.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnCadastrarMedico) {
            initModel();
            SalvarMedico();
        }else{
            Remover();
        }
        finish();
    }


    private void SalvarMedico() {
        db.child(String.valueOf(medicoModel.getId())).setValue(medicoModel);
        showToast("Medico Salvo com sucesso");
    }

    protected void initModel() {
        if(medicoModel == null){
            medicoModel = new MedicoModel(edtNomeMedico.getText().toString().trim(),
                    edtCrmMedico.getText().toString().trim(),
                    edtEspecificacaoMedico.getText().toString().trim());
        }
        else{
            medicoModel = new MedicoModel(medicoModel.getId(),edtNomeMedico.getText().toString().trim(),
                    edtCrmMedico.getText().toString().trim(),
                    edtEspecificacaoMedico.getText().toString().trim());
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
            medicoModel = (MedicoModel) bundle.getSerializable("medicoModel");
            if (medicoModel != null) {
                edtNomeMedico.setText(medicoModel.getNome());
                edtCrmMedico.setText(medicoModel.getCrm());
                edtEspecificacaoMedico.setText(medicoModel.getEspecificacao());
            }
        }
    }

    private void Remover(){
        db.child(String.valueOf(medicoModel.getId())).removeValue();
        finish();
    }

}
