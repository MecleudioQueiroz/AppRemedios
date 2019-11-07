package com.remedios.appremedios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.remedios.appremedios.Model.MedicoModel;
import com.remedios.appremedios.Repository.MedicoRepository;

public class Medico extends AppCompatActivity {
    private EditText nome;
    private EditText crm;
    private EditText especificacao;
    private MedicoRepository medicoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico);

        nome = findViewById(R.id.edtNomeMedico);
        crm = findViewById(R.id.edtCrmMedico);
        especificacao = findViewById(R.id.edtEspecificacaoMedico);
    }

    public void salvarMedico(View view){
        MedicoModel medico = new MedicoModel();
        medico.setNome(nome.getText().toString());
        medico.setCrm(crm.getText().toString());
        medico.setEspecificacao(especificacao.getText().toString());
        long id = medicoRepository.Insert(medico);
        Toast.makeText(this,"Medico inserido com sucesso! " + id, Toast.LENGTH_SHORT).show();
    }
}
