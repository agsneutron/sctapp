package com.SCT.mx.SCT;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.SCT.mx.SCT.domain.ProgramasBeneficiarios;
import com.SCT.mx.SCT.domain.ProgramasInversion;
import com.SCT.mx.SCT.ui.ResultadosAdapter;
import com.programas.mx.programas.R;

import java.util.ArrayList;

public class Infraestructura extends AppCompatActivity {



    ArrayList<ProgramasBeneficiarios> datasetPB;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infraestructura);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //RV

        ArrayList<ProgramasBeneficiarios> arregloPB = new ArrayList<>();
        arregloPB.add(new ProgramasBeneficiarios("Obras", "Inversión"));
        arregloPB.add(new ProgramasBeneficiarios("Nutrición con Valor", "46,290"));
        arregloPB.add(new ProgramasBeneficiarios("Tu Empleo Formal", "40,285"));
        arregloPB.add(new ProgramasBeneficiarios("Asistencia Social a la Comunidad", "38,890"));
        arregloPB.add(new ProgramasBeneficiarios("Apoyo al Estudiante", "33,296"));
        arregloPB.add(new ProgramasBeneficiarios("Apoyo a Mujeres Jefas de Familia", "29,089"));
        arregloPB.add(new ProgramasBeneficiarios("Formación del Sector Artesanal", "26,489"));
        arregloPB.add(new ProgramasBeneficiarios("Proyectos Productivos", "25,728"));
        arregloPB.add(new ProgramasBeneficiarios("Apoyo a Asociaciones Culturales", "22,862"));
        arregloPB.add(new ProgramasBeneficiarios("Beca Deportiva", "20,876"));
        arregloPB.add(new ProgramasBeneficiarios("Atención salud Visual", "19,873"));
        arregloPB.add(new ProgramasBeneficiarios("Premio Estatal a la Juventud", "18,250"));
        arregloPB.add(new ProgramasBeneficiarios("Mejoramiento de Vivienda", "18.998"));
        arregloPB.add(new ProgramasBeneficiarios("Programa de Apoyo a Pequeños Productores", "16,480"));
        arregloPB.add(new ProgramasBeneficiarios("Apoyo a la Población Indígena", "15,027"));


        datasetPB = new ArrayList<ProgramasBeneficiarios>();
        datasetPB = arregloPB;
        recyclerView = (RecyclerView) findViewById(R.id.rv_list_inf);
        recyclerView.setHasFixedSize(true);
        adapter = new ResultadosAdapter(datasetPB, R.layout.item_list_contenti, Infraestructura.this);//(cobroarraylist, R.layout.cobrador_item_lista);
        //recyclerView.setAdapter(new CobroAdapter(cobroarraylist, R.layout.cobrador_item_lista));  //cobroarraylist
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Infraestructura.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }





}
