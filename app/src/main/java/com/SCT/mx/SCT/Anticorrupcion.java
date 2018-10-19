package com.SCT.mx.SCT;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.SCT.mx.SCT.domain.ProgramaOb;
import com.SCT.mx.SCT.domain.ProgramasBeneficiarios;
import com.SCT.mx.SCT.domain.ProgramasInversion;
import com.SCT.mx.SCT.ui.ResultadosAdapter;
import com.SCT.mx.SCT.ui.ResultadosAdapterI;
import com.SCT.mx.SCT.ui.ResultadosAdapterx;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.programas.mx.programas.R;

import java.util.ArrayList;
import java.util.List;

public class Anticorrupcion extends AppCompatActivity {



    ArrayList<ProgramasBeneficiarios> datasetPB;
    ArrayList<ProgramasInversion> datasetPI;
    private RecyclerView recyclerView, recyclerViewI;
    private RecyclerView.Adapter adapter, adapterI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anticorrupcion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Nombre, Meta_total, avance_total, avance_unidades, avance_porcentaje, avance_importe

        ArrayList<ProgramasBeneficiarios> arregloPB = new ArrayList<>();
        arregloPB.add(new ProgramasBeneficiarios("Proyecto" ,"Inversión"));

        arregloPB.add(new ProgramasBeneficiarios("Proyectadas - CONSERVACION DEL CAMINO ALIANZA PROD..." ,"$ 50.346,578.00"));
        arregloPB.add(new ProgramasBeneficiarios("Proyectadas - ULUMAL-VILLA DE GUADALUPE-SAN MIGUEL..." ,"$ 58.345,643.00"));
        arregloPB.add(new ProgramasBeneficiarios("Proyectadas - CONSTRUCCION DE LAS OBRAS CHIAPAS DE...,","$ 80.858,345.00"));
        arregloPB.add(new ProgramasBeneficiarios("Proyectadas - CONSERVACION DEL CAMINO ALIANZA PROD..." ,"$ 70.786,578.00"));
        arregloPB.add(new ProgramasBeneficiarios("En Proceso - ONSERVACION DEL CAMINO E.C. (MONCLOVA...", "$ 81,300,643.00"));
        arregloPB.add(new ProgramasBeneficiarios("Asignadas - CAMINO NUEVA VIDA - UNION 20 DE JUNIO ...", "$ 90,800,000.00"));
        arregloPB.add(new ProgramasBeneficiarios("Proyectadas - CONSERVACION DEL CAMINO ALIANZA PROD..." ,"$ 50.346,578.00"));
        arregloPB.add(new ProgramasBeneficiarios("En Proceso - ONSERVACION DEL CAMINO E.C. (MONCLOVA...", "$ 81,300,643.00"));
        arregloPB.add(new ProgramasBeneficiarios("Asignadas - CAMINO NUEVA VIDA - UNION 20 DE JUNIO ...", "$ 90,800,000.00"));
        arregloPB.add(new ProgramasBeneficiarios("En Proceso - ONSERVACION DEL CAMINO E.C. (MONCLOVA...", "$ 81,300,643.00"));
        arregloPB.add(new ProgramasBeneficiarios("Asignadas - ULUMAL-VILLA DE GUADALUPE-SAN MIGUEL, ...", "$ 90,800,000.00"));
        arregloPB.add(new ProgramasBeneficiarios("En Proceso - ONSERVACION DEL CAMINO E.C. (MONCLOVA...", "$ 81,300,643.00"));
        arregloPB.add(new ProgramasBeneficiarios("Asignadas - CAMINO NUEVA VIDA - UNION 20 DE JUNIO ... ", "$ 90,800,000.00"));
        arregloPB.add(new ProgramasBeneficiarios("En Proceso - ONSERVACION DEL CAMINO E.C. (MONCLOVA...", "$ 81,300,643.00"));
        arregloPB.add(new ProgramasBeneficiarios("Asignadas - CAMINO NUEVA VIDA - UNION 20 DE JUNIO ...", "$ 90,800,000.00"));

        datasetPB = new ArrayList<ProgramasBeneficiarios>();
        datasetPB = arregloPB;
        recyclerView = (RecyclerView) findViewById(R.id.rv_list1);
        recyclerView.setHasFixedSize(true);
        adapter = new ResultadosAdapter(datasetPB, R.layout.item_list_contenti, Anticorrupcion.this);//(cobroarraylist, R.layout.cobrador_item_lista);
        //recyclerView.setAdapter(new CobroAdapter(cobroarraylist, R.layout.cobrador_item_lista));  //cobroarraylist
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Anticorrupcion.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //rvl2
        ArrayList<ProgramasInversion> arregloPI = new ArrayList<>();



        arregloPI.add(new ProgramasInversion("Proyecto" ,"Inversión"));
        arregloPI.add(new ProgramasInversion("Menor a 5M - Radio Federal Difurosa Mexiquense", "$ 4,286,278.00"));

        arregloPI.add(new ProgramasInversion("Menor a 5M - Televisión Civil Nuevo canal 11TV", "$ 1,576,588.00"));

        arregloPI.add(new ProgramasInversion("Menor a 5M- Internet Red Mexico Conectado", "$ 1,506,256.00"));
        arregloPI.add(new ProgramasInversion("Menor a 5M -Telefonía Red Rural PPT", "$ 2,776,538.00"));
        arregloPI.add(new ProgramasInversion("Mayor a 5M - Radio Federal - Difusor 457.FM", "$ 7,286,278.00"));

        arregloPI.add(new ProgramasInversion("Mayor a 5M - Televisión Civil", "$ 13,576,588.00"));

        arregloPI.add(new ProgramasInversion("Mayor a 5M- Internet", "$ 18,506,256.00"));
        arregloPI.add(new ProgramasInversion("Mayor a 5M -Telefonía", "$ 23,776,538.00"));
        arregloPI.add(new ProgramasInversion("Menor a 5M - Radio Federal", "$ 4,286,278.00"));

        arregloPI.add(new ProgramasInversion("Menor a 5M - Televisión Civil", "$ 1,576,588.00"));

        arregloPI.add(new ProgramasInversion("Menor a 5M- Internet", "$ 1,506,256.00"));
        arregloPI.add(new ProgramasInversion("Menor a 5M -Telefonía", "$ 2,776,538.00"));
        arregloPI.add(new ProgramasInversion("Mayor a 5M - Radio Federal", "$ 7,286,278.00"));

        arregloPI.add(new ProgramasInversion("Mayor a 5M - Televisión Civil", "$ 13,576,588.00"));

        arregloPI.add(new ProgramasInversion("Mayor a 5M- Internet", "$ 18,506,256.00"));
        arregloPI.add(new ProgramasInversion("Mayor a 5M -Telefonía", "$ 23,776,538.00"));
        /*arregloPI.add(new ProgramasInversion("Tu Empleo Formal", "$ 1,535,843.00"));
        arregloPI.add(new ProgramasInversion("Asistencia Social a la Comunidad", "$ 1,457,239.00"));
        arregloPI.add(new ProgramasInversion("Apoyo al Estudiante", "$ 1,334,164.00"));
        arregloPI.add(new ProgramasInversion("Atención salud Visual", "$ 1,006,235.00"));
        arregloPI.add(new ProgramasInversion("Premio Estatal a la Juventud", "$ 975,246.00"));
        arregloPI.add(new ProgramasInversion("Mejoramiento de Vivienda", "$ 753,125.00"));
        arregloPI.add(new ProgramasInversion("Programa de Apoyo a Pequeños Productores", "$ 682,349.00"));
        arregloPI.add(new ProgramasInversion("Apoyo a la Población Indígena", "$ 579,835.00"));
        arregloPI.add(new ProgramasInversion("Apoyo a Mujeres Jefas de Familia", "$ 509,998.00"));
        arregloPI.add(new ProgramasInversion("Formación del Sector Artesanal", "$ 459,976.00"));
        arregloPI.add(new ProgramasInversion("Proyectos Productivos", "$ 431,930.00"));
*/

        datasetPI = new ArrayList<ProgramasInversion>();
        datasetPI = arregloPI;
        recyclerViewI = (RecyclerView) findViewById(R.id.rv_list2);
        recyclerViewI.setHasFixedSize(true);
        adapterI = new ResultadosAdapterI(datasetPI, R.layout.item_list_contenti, Anticorrupcion.this);//(cobroarraylist, R.layout.cobrador_item_lista);
        //recyclerView.setAdapter(new CobroAdapter(cobroarraylist, R.layout.cobrador_item_lista));  //cobroarraylist
        recyclerViewI.setAdapter(adapterI);
        recyclerViewI.setLayoutManager(new LinearLayoutManager(Anticorrupcion.this));
        recyclerViewI.setItemAnimator(new DefaultItemAnimator());

        // inicia chart
        BarChart bchart = (BarChart) findViewById(R.id.i_bchart);


        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        //for (int i = (int) 0; i < 10 + 1; i++) {
        //    float val = (float) (Math.random());
        //    yVals1.add(new BarEntry(i, val));
        //}



        yVals1.add(new BarEntry(1,50.34f, "Autotransporte Federal"));
        yVals1.add(new BarEntry(2,81.30f, "Aeronáutica Civil"));
        yVals1.add(new BarEntry(3,90.8f, "Desarrollo Ferroviario"));
       // yVals1.add(new BarEntry(4,31.33f, "Transporte Marítimo"));




        /*yVals1.add(new BarEntry(5,10,"Coahuila"));
        yVals1.add(new BarEntry(6,0,"Colima"));
        yVals1.add(new BarEntry(7,56,"Chiapas"));
        yVals1.add(new BarEntry(8,5,"Ciudad de México"));
        yVals1.add(new BarEntry(9,7,"Durango"));
        yVals1.add(new BarEntry(10,32,"Guanajuato"));
        yVals1.add(new BarEntry(11,45,"Guerrero"));
        yVals1.add(new BarEntry(12,17,"Hidalgo"));
        yVals1.add(new BarEntry(13,25,"Jalisco"));
        yVals1.add(new BarEntry(14,24,"Ciudad de México"));
        yVals1.add(new BarEntry(15,29,"Michoacán"));*/
        BarDataSet set1;

        set1 = new BarDataSet(yVals1, "Proyectados, En Proceso, Asignados 2018");
        set1.setColors(ColorTemplate.MATERIAL_COLORS);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);

        data.setValueTextSize(10f);
        data.setBarWidth(0.9f);


        bchart.setTouchEnabled(true);
        bchart.setData(data);
        bchart.setDrawGridBackground(false);
        bchart.getDescription().setEnabled(true);


        bchart.setDrawValueAboveBar(true);



        bchart.setDrawValueAboveBar(true);

        Legend l = bchart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setXEntrySpace(2f);
        l.setYEntrySpace(2f);
        l.setYOffset(0f);
        l.setWordWrapEnabled(true);
        l.setTextSize(5f);

        //inicia top programas vs beneficiarios


        //chart contratos
        //chart
        PieChart bchart4 = (PieChart) findViewById(R.id.i_bchart4);

        List<PieEntry> entries4 = new ArrayList<>();



        entries4.add(new PieEntry(39764967f, " Mayor a 5 MDP"));
        entries4.add(new PieEntry(84543987, " Menor a 5 MDP"));


        /*entries3.add(new PieEntry(1.33f,"Apoyo al Estudiante"));
        entries3.add(new PieEntry(1.00f,"Atención salud Visual"));
        entries3.add(new PieEntry(0.97f,"Premio Estatal a la Juventud"));
        entries3.add(new PieEntry(0.75f,"Mejoramiento de Vivienda"));
        entries3.add(new PieEntry(0.68f,"Programa de Apoyo a Pequeños Productores"));
        entries3.add(new PieEntry(0.57f,"Apoyo a la Población Indígena"));
        entries3.add(new PieEntry(0.50f,"Apoyo a Mujeres Jefas de Familia"));
        entries3.add(new PieEntry(0.45f,"Formación del Sector Artesanal"));
        entries3.add(new PieEntry(0.43f,"Proyectos Productivos"));*/

        PieDataSet set4 = new PieDataSet(entries4, " Contratos");
        PieData data4 = new PieData(set4);
        bchart4.setData(data4);
        bchart4.invalidate(); // refresh

        set4.setColors(ColorTemplate.MATERIAL_COLORS);

        data4.setValueTextSize(15f);
        data4.setValueTextColor(Color.DKGRAY);

        // data.setBarWidth(0.9f);

        bchart4.setTouchEnabled(true);
        bchart4.setData(data4);
        bchart4.setDrawEntryLabels(false);
        bchart4.setEntryLabelColor(Color.BLACK);
        bchart4.setDrawEntryLabels(true);
        bchart4.setEntryLabelTextSize(8f);
        bchart4.getLegend().setEnabled(true);
        bchart4.getDescription().setText("" );


        Legend l3 = bchart4.getLegend();
        l3.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l3.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l3.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l3.setDrawInside(false);
        l3.setXEntrySpace(2f);
        l3.setYEntrySpace(2f);
        l3.setYOffset(0f);
        l3.setWordWrapEnabled(true);
        l3.setTextSize(10f);

        //
    }

}
