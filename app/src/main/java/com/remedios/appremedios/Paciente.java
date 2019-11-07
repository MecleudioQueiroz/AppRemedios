package com.remedios.appremedios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.remedios.appremedios.Model.PacienteModel;
import com.remedios.appremedios.Repository.PacienteRepository;

public class Paciente extends AppCompatActivity {
    private EditText nome;
    private EditText sobreNome;
    private EditText idade;
    private EditText telefone;
    private EditText endereco;
    private PacienteRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        nome = findViewById(R.id.edtNome);
        sobreNome = findViewById(R.id.edtSobreNome);
        idade = findViewById(R.id.edtIdade);
        telefone = findViewById(R.id.edtTelefone);
        endereco = findViewById(R.id.edtEndereco);


    }

    public void salvar(View view){
        PacienteModel paciente = new PacienteModel();
        paciente.setNome(nome.getText().toString());
        paciente.setSobreNome(sobreNome.getText().toString());
        paciente.setIdade(idade.getText().toString());
        paciente.setTelefone(telefone.getText().toString());
        paciente.setEndereco(endereco.getText().toString());
        long id =  repository.insert(paciente);
        Toast.makeText(this,"Paciente inserido com sucesso! " + id,Toast.LENGTH_SHORT).show();
    }

}
