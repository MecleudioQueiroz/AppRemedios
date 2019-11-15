package com.remedios.appremedios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.remedios.appremedios.Model.RemedioModel;

public class RemedioActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference db;
    private RemedioModel remedioModel;
    private EditText edtNomeMedicamento,edtLaboratorio,edtDescricao,edtClasseTerapeutica;
    private RadioButton rdGenerico,rdSimilar,rdEtico;
    private Button btnCadastrarRemedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedio);

        firebaseDatabase = FirebaseDatabase.getInstance();
        db = firebaseDatabase.getReference("RemedioModel");

        initViews();
        pegandoClienteDoBundle();
    }

    protected void initViews() {
        edtNomeMedicamento = findViewById(R.id.edtNomeMedicamento);
        edtLaboratorio = findViewById(R.id.edtLaboratorio);
        edtDescricao = findViewById(R.id.edtDescricao);
        edtClasseTerapeutica = findViewById(R.id.edtClasseTerapeutica);
        rdGenerico = findViewById(R.id.rdGenerico);
        rdSimilar = findViewById(R.id.rdSimilar);
        rdEtico = findViewById(R.id.rdEtico);
        btnCadastrarRemedio = findViewById(R.id.btnCadastrarRemedio);
        btnCadastrarRemedio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnCadastrarRemedio) {
            initModel();
            SalvarMedico();
        }else{
            Remover();
        }
        finish();
    }


    private void SalvarMedico() {
        db.child(String.valueOf(remedioModel.getId())).setValue(remedioModel);
        showToast("Remedio Salvo com sucesso");
    }

    protected void initModel() {
        if(remedioModel == null){
            remedioModel = new RemedioModel(edtNomeMedicamento.getText().toString().trim(),
                    edtLaboratorio.getText().toString().trim(),
                    edtClasseTerapeutica.getText().toString().trim(),
                    edtDescricao.getText().toString().trim(),
                    rdGenerico.getText().toString().trim(),
                    rdSimilar.getText().toString().trim(),
                    rdEtico.getText().toString().trim());
        }
        else{
            remedioModel = new RemedioModel(remedioModel.getId(),edtNomeMedicamento.getText().toString().trim(),
                    edtLaboratorio.getText().toString().trim(),
                    edtClasseTerapeutica.getText().toString().trim(),
                    edtDescricao.getText().toString().trim(),
                    rdGenerico.getText().toString().trim(),
                    rdSimilar.getText().toString().trim(),
                    rdEtico.getText().toString().trim());
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
            remedioModel = (RemedioModel) bundle.getSerializable("remedioModel");
            if (remedioModel != null) {
                edtNomeMedicamento.setText(remedioModel.getNomeRemedio());
                edtLaboratorio.setText(remedioModel.getLaboratorio());
                edtDescricao.setText(remedioModel.getDescricao());
                edtClasseTerapeutica.setText(remedioModel.getClasseTerapeuta());
                rdGenerico.setText(remedioModel.getGenerico());
                rdSimilar.setText(remedioModel.getSimilar());
                rdEtico.setText(remedioModel.getEtico());
            }
        }
    }

    private void Remover(){
        db.child(String.valueOf(remedioModel.getId())).removeValue();
        finish();
    }

}
