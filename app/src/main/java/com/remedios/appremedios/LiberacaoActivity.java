package com.remedios.appremedios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.remedios.appremedios.Model.LiberacaoModel;
import com.remedios.appremedios.Model.PacienteModel;

import java.util.ArrayList;
import java.util.List;

public class LiberacaoActivity extends AppCompatActivity{

    private DatabaseReference db;
    private List<LiberacaoModel> liberacaoModels;
    private Spinner spinnerpaciente, spinnermedico, spinnerremedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liberacao);

        db = FirebaseDatabase.getInstance().getReference().child("liberacaoModels");
        popularLiberacao();

        liberacaoModels = new ArrayList<LiberacaoModel>();
        spinnerpaciente = findViewById(R.id.spPaciente);
        spinnermedico = findViewById(R.id.spinnerMedico);
        spinnerremedio = findViewById(R.id.spinnerMedico);
        popularSpinner();
    }


    public void popularSpinner(){
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                liberacaoModels.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    LiberacaoModel liberacaoModel = objSnapshot.getValue(LiberacaoModel.class);
                    liberacaoModels.add(liberacaoModel);
                }

                spinnerpaciente.setAdapter(new ArrayAdapter<LiberacaoModel>(LiberacaoActivity.this, android.R.layout.simple_list_item_1, liberacaoModels));
                spinnermedico.setAdapter(new ArrayAdapter<LiberacaoModel>(LiberacaoActivity.this, android.R.layout.simple_list_item_1, liberacaoModels));
                spinnerremedio.setAdapter(new ArrayAdapter<LiberacaoModel>(LiberacaoActivity.this, android.R.layout.simple_list_item_1, liberacaoModels));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void popularLiberacao(){
        SalvarLiberacao(new LiberacaoModel(1, "paciente"));
        SalvarLiberacao(new LiberacaoModel(2, "medico"));
        SalvarLiberacao(new LiberacaoModel(3, "remedio"));
    }

    private void SalvarLiberacao(LiberacaoModel liberacaoModel){
        db.child(String.valueOf(liberacaoModel.getId())).setValue(liberacaoModel);
    }
}
