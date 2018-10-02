package com.programas.mx.programas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.TextView;

import java.util.ArrayList;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.programas.mx.programas.domain.ProgramasBeneficiarios;
import com.programas.mx.programas.domain.ProgramasInversion;
import com.programas.mx.programas.ui.ResultadosAdapter;
import com.programas.mx.programas.ui.ResultadosAdapterI;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;

    ArrayList<ProgramasBeneficiarios> datasetPB;
    ArrayList<ProgramasInversion> datasetPI;
    private RecyclerView recyclerView, recyclerViewI;
    private RecyclerView.Adapter adapter, adapterI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // inicia chart
        BarChart bchart = (BarChart) findViewById(R.id.bchart);


        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = (int) 0; i < 10 + 1; i++) {
            float val = (float) (Math.random());
            yVals1.add(new BarEntry(i, val));
        }

        BarDataSet set1;

        set1 = new BarDataSet(yVals1, "The year 2017");
        set1.setColors(ColorTemplate.MATERIAL_COLORS);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);

        data.setValueTextSize(10f);
        data.setBarWidth(0.9f);

        bchart.setTouchEnabled(false);
        bchart.setData(data);

        //inicia top programas vs beneficiarios

        ArrayList<ProgramasBeneficiarios> arregloPB = new ArrayList<>();
        arregloPB.add(new ProgramasBeneficiarios("Apoyo a la Población Vulnerable", "55436"));
        arregloPB.add(new ProgramasBeneficiarios("Nutrición con Valor", "46290"));
        arregloPB.add(new ProgramasBeneficiarios("Tu Empleo Formal", "40285"));
        arregloPB.add(new ProgramasBeneficiarios("Asistencia Social a la Comunidad", "38890"));
        arregloPB.add(new ProgramasBeneficiarios("Apoyo al Estudiante", "33296"));
        arregloPB.add(new ProgramasBeneficiarios("Apoyo a Mujeres Jefas de Familia", "29089"));
        arregloPB.add(new ProgramasBeneficiarios("Formación del Sector Artesanal", "26489"));
        arregloPB.add(new ProgramasBeneficiarios("Proyectos Productivos", "25728"));
        arregloPB.add(new ProgramasBeneficiarios("Apoyo a Asociaciones Culturales", "22862"));
        arregloPB.add(new ProgramasBeneficiarios("Beca Deportiva", "20876"));
        arregloPB.add(new ProgramasBeneficiarios("Atención salud Visual", "19873"));
        arregloPB.add(new ProgramasBeneficiarios("Premio Estatal a la Juventud", "18250"));
        arregloPB.add(new ProgramasBeneficiarios("Mejoramiento de Vivienda", "18998"));
        arregloPB.add(new ProgramasBeneficiarios("Programa de Apoyo a Pequeños Productores", "16480"));
        arregloPB.add(new ProgramasBeneficiarios("Apoyo a la Población Indígena", "15027"));


        datasetPB = new ArrayList<ProgramasBeneficiarios>();
        datasetPB = arregloPB;
        recyclerView = (RecyclerView) findViewById(R.id.rv_beneficiarios);
        recyclerView.setHasFixedSize(true);
        adapter = new ResultadosAdapter(datasetPB, R.layout.item_list_content, MainActivity.this);//(cobroarraylist, R.layout.cobrador_item_lista);
        //recyclerView.setAdapter(new CobroAdapter(cobroarraylist, R.layout.cobrador_item_lista));  //cobroarraylist
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //inicia top programas vs inversión

        ArrayList<ProgramasInversion> arregloPI = new ArrayList<>();
        arregloPI.add(new ProgramasInversion("Apoyo a Asociaciones Culturales", "$ 72,286,278.00"));
        arregloPI.add(new ProgramasInversion("Beca Deportiva", "$ 43,576,588.00"));
        arregloPI.add(new ProgramasInversion("Apoyo a la Población Vulnerable", "$ 23,876,538.00"));
        arregloPI.add(new ProgramasInversion("Nutrición con Valor", "$ 12,456,256.00"));
        arregloPI.add(new ProgramasInversion("Tu Empleo Formal", "$ 4,535,843.00"));
        arregloPI.add(new ProgramasInversion("Asistencia Social a la Comunidad", "$ 2,457,239.00"));
        arregloPI.add(new ProgramasInversion("Apoyo al Estudiante", "$ 1,834,164.00"));
        arregloPI.add(new ProgramasInversion("Atención salud Visual", "$ 1,006,235.00"));
        arregloPI.add(new ProgramasInversion("Premio Estatal a la Juventud", "$ 975,246.00"));
        arregloPI.add(new ProgramasInversion("Mejoramiento de Vivienda", "$ 753,125.00"));
        arregloPI.add(new ProgramasInversion("Programa de Apoyo a Pequeños Productores", "$ 682,349.00"));
        arregloPI.add(new ProgramasInversion("Apoyo a la Población Indígena", "$ 579,835.00"));
        arregloPI.add(new ProgramasInversion("Apoyo a Mujeres Jefas de Familia", "$ 509,998.00"));
        arregloPI.add(new ProgramasInversion("Formación del Sector Artesanal", "$ 459,976.00"));
        arregloPI.add(new ProgramasInversion("Proyectos Productivos", "$ 431,930.00"));


        datasetPI = new ArrayList<ProgramasInversion>();
        datasetPI = arregloPI;
        recyclerViewI = (RecyclerView) findViewById(R.id.rv_presupuesto);
        recyclerViewI.setHasFixedSize(true);
        adapterI = new ResultadosAdapterI(datasetPI, R.layout.item_list_contenti, MainActivity.this);//(cobroarraylist, R.layout.cobrador_item_lista);
        //recyclerView.setAdapter(new CobroAdapter(cobroarraylist, R.layout.cobrador_item_lista));  //cobroarraylist
        recyclerViewI.setAdapter(adapterI);
        recyclerViewI.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewI.setItemAnimator(new DefaultItemAnimator());


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(MainActivity.this, ProgramasActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

/*
*
*
* HIChartView chartView = (HIChartView) findViewById(R.id.hc);

        HIOptions options = new HIOptions();

        HIChart chart = new HIChart();


        chart.setType("pie");

        HIOptions3d options3d = new HIOptions3d ();


        options3d.setEnabled(true);
        options3d.setAlpha(45);
        options3d.setBeta(0);
        chart.setOptions3d(options3d);


        HITitle title = new HITitle();
        title.setText("Browser market shares at a specific website, 2014");
        options.setTitle(title);

        HITooltip tooltip = new HITooltip();
        tooltip.setPointFormat("{series.name}: <b>{point.percentage:.1f}%</b>");
        options.setTooltip(tooltip);

        HIPlotOptions plotOptions = new HIPlotOptions();
        HIPie pie = new HIPie();
        plotOptions.setPie(new HIPie());
        plotOptions.allowPointSelect = true;
        plotOptions.pie.cursor = "pointer";
        plotOptions.pie.depth = 35;
        plotOptions.pie.dataLabels = new HIDataLabels();
        plotOptions.pie.dataLabels.enabled = true;
        plotOptions.pie.dataLabels.format = "{point.name}";
        options.plotOptions = plotOptions;

        HIPie series1 = new HIPie();
        series1.type = "pie";
        series1.name = "Browser share";
        Object[] firefoxData = new Object[] { "Firefox", 45.0 };
        Object[] IEData = new Object[] { "IE", 26.0 };
        HashMap<String, Object> chromeData = new HashMap<>();
        chromeData.put("name", "Chrome");
        chromeData.put("y", 12.8);
        chromeData.put("sliced", true);
        chromeData.put("selected", true);
        Object[] safariData = new Object[] { "Safari", 8.5 };
        Object[] operaData = new Object[] { "Opera", 6.2 };
        Object[] othersData = new Object[] { "Others", 0.7 };
        series1.data = new ArrayList<>(Arrays.asList(firefoxData, IEData, chromeData, safariData, operaData, othersData));
        options.series = new ArrayList<>(Arrays.asList(series1));
        chartView.options = options;*/