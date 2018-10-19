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
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
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





        yVals1.add(new BarEntry(1,new float[] { 2344, 4546, 4532 },"En proyecto"));
        yVals1.add(new BarEntry(2,new float[] { 3235, 2143,3432 },"En proceso"));
        yVals1.add(new BarEntry(3,new float[] { 1302, 2143 ,2352},"Asignadas"));
        yVals1.add(new BarEntry(4,new float[] { 1256, 3678, 2765 },"En proyecto"));
        yVals1.add(new BarEntry(5,new float[] { 2456, 3457,2353 },"En proceso"));
        yVals1.add(new BarEntry(6,new float[] { 977, 935 ,879},"Asignadas"));
        yVals1.add(new BarEntry(7,new float[] { 1098, 3086, 2568 },"En proyecto"));
        yVals1.add(new BarEntry(8,new float[] { 987, 2009,3547 },"En proceso"));

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

        set1 = new BarDataSet(yVals1, "MDP");
        //set1.setColors(ColorTemplate.MATERIAL_COLORS);
        set1.setColors(getColors());
        set1.setStackLabels(new String[]{"En Proyecto.", "En Proceso.", "Asignadas."});

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);

        data.setValueTextSize(10f);
        data.setBarWidth(0.9f);


        XAxis xAxis1 = bchart.getXAxis();
        // Set the xAxis position to bottom. Default is top
        xAxis1.setPosition(XAxis.XAxisPosition.TOP);
        //Customizing x axis value
        final String[] months1 = new String[]{"","AGS", "BC", "BCS", "CAM", "COH","COL","CHI","CDMX"}; //,"DUR","GTO","GRO","HGO","JAL","MICH","PU"};

        IAxisValueFormatter formatter1 = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return months1[(int) value];
            }
        };
        xAxis1.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis1.setValueFormatter(formatter1);

        bchart.setTouchEnabled(true);
        bchart.setData(data);
        bchart.setDrawGridBackground(false);
        bchart.setDrawBarShadow(false);
        bchart.getDescription().setEnabled(true);
        bchart.getDescription().setText("Licitaciones 2018");



        bchart.setDrawValueAboveBar(false);

        Legend l = bchart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setForm(Legend.LegendForm.CIRCLE);
        l.setDrawInside(true);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(7f);
        l.setYOffset(7f);
        l.setWordWrapEnabled(true);
        l.setTextSize(12f);

        //inicia top programas vs benefi
        //inicia top programas vs beneficiarios


        //chart contratos
        //chart
        PieChart bchart4 = (PieChart) findViewById(R.id.i_bchart4);

        List<PieEntry> entries4 = new ArrayList<>();



        entries4.add(new PieEntry(39764967f, "Mayor a 5 MDP"));
        entries4.add(new PieEntry(84543987, "Menor a 5 MDP"));


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
        l3.setYOffset(2f);
        l3.setWordWrapEnabled(true);
        l3.setTextSize(12f);

        //
    }


    private int[] getColors() {

        int stacksize = 3;

        // have as many colors as stack-values per entry
        int[] colors = new int[stacksize];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = ColorTemplate.MATERIAL_COLORS[i];
        }

        return colors;
    }
}
