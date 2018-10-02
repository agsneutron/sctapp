package com.programas.mx.programas;

import android.content.Intent;
import android.graphics.Color;
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
import java.util.List;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.programas.mx.programas.domain.ProgramasBeneficiarios;
import com.programas.mx.programas.domain.ProgramasInversion;
import com.programas.mx.programas.ui.ResultadosAdapter;
import com.programas.mx.programas.ui.ResultadosAdapterI;



public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener, OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;
    private GoogleMap mMap;

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


        //MAPA
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //

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

        set1 = new BarDataSet(yVals1, "Programas a 2018");
        set1.setColors(ColorTemplate.MATERIAL_COLORS);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);

        data.setValueTextSize(10f);
        data.setBarWidth(0.9f);


        bchart.setTouchEnabled(true);
        bchart.setData(data);
        bchart.setDrawGridBackground(false);


        bchart.setDrawValueAboveBar(true);

        Legend l = bchart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setDrawInside(true);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        //inicia top programas vs beneficiarios

        //CHART

        HorizontalBarChart mChart2 = findViewById(R.id.bchart3);
        mChart2.setOnChartValueSelectedListener(this);
        // mChart.setHighlightEnabled(false);

        mChart2.setDrawBarShadow(true);

        mChart2.setDrawValueAboveBar(true);

        mChart2.getDescription().setEnabled(true);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart2.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        mChart2.setPinchZoom(true);

        // draw shadows for each bar that show the maximum value
        // mChart.setDrawBarShadow(true);

        mChart2.setDrawGridBackground(false);

        XAxis xl = mChart2.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        //xl.setTypeface(mTfLight);
        xl.setDrawAxisLine(true);
        xl.setDrawGridLines(false);
        xl.setGranularity(10f);

        YAxis yl = mChart2.getAxisLeft();
        //yl.setTypeface(mTfLight);
        yl.setDrawAxisLine(true);
        yl.setDrawGridLines(true);
        yl.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//        yl.setInverted(true);

        YAxis yr = mChart2.getAxisRight();
        //yr.setTypeface(mTfLight);
        yr.setDrawAxisLine(true);
        yr.setDrawGridLines(false);
        yr.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//        yr.setInverted(true);

        float barWidth = 0.7f;
        float spaceForBar = 10f;

        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();

        for (int i = (int) 0; i < 10 + 1; i++) {
            float val = (float) (Math.random());
            yVals2.add(new BarEntry(i, val));
        }

        BarDataSet set2;

        set2 = new BarDataSet(yVals2, "Beneficiarios por Programa");

        set2.setDrawIcons(true);

        ArrayList<IBarDataSet> dataSets2 = new ArrayList<IBarDataSet>();
        dataSets2.add(set2);

        set2.setColors(ColorTemplate.MATERIAL_COLORS);

        BarData data2 = new BarData(dataSets2);
        data2.setValueTextSize(10f);
        //data.setValueTypeface(mTfLight);
        data2.setBarWidth(barWidth);
        mChart2.setData(data2);

        mChart2.setFitBars(true);
        mChart2.animateY(2500);


        Legend l2 = mChart2.getLegend();
        l2.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l2.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l2.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l2.setDrawInside(false);
        l2.setFormSize(8f);
        l2.setXEntrySpace(4f);
        //RV

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

        //chart
        PieChart bchart3 = (PieChart) findViewById(R.id.bchart2);

        List<PieEntry> entries3 = new ArrayList<>();

        entries3.add(new PieEntry(18.5f, "Nutrición con Valor"));
        entries3.add(new PieEntry(26.7f, "Atención salud Visual"));
        entries3.add(new PieEntry(24.0f, "Mejoramiento de Vivienda"));
        entries3.add(new PieEntry(30.8f, "Apoyo al Estudiante"));

        PieDataSet set3 = new PieDataSet(entries3, "Miles de Beneficiarios por Programa");
        PieData data3 = new PieData(set3);
        bchart3.setData(data3);
        bchart3.invalidate(); // refresh


        set3.setColors(ColorTemplate.MATERIAL_COLORS);

        data3.setValueTextSize(20f);
        data3.setValueTextColor(Color.DKGRAY);
        // data.setBarWidth(0.9f);

        bchart3.setTouchEnabled(true);
        bchart3.setData(data3);
        bchart3.setEntryLabelTextSize(10f);
        bchart3.setEntryLabelColor(Color.BLACK);
        bchart3.setDrawEntryLabels(true);

        Legend l3 = bchart3.getLegend();
        l3.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l3.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l3.setOrientation(Legend.LegendOrientation.VERTICAL);
        l3.setDrawInside(false);
        l3.setXEntrySpace(7f);
        l3.setYEntrySpace(0f);
        l3.setYOffset(0f);





        //RV

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

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Mexico and move the camera.
        LatLng mexico = new LatLng(19.4326009, -99.1333416);
        mMap.addMarker(new MarkerOptions().position(mexico).title("Ciudad de México, México"));

        LatLng bc = new LatLng(32.6519, -115.4683);
        mMap.addMarker(new MarkerOptions().position(bc).title("Baja California, México"));

        LatLng bcs = new LatLng(23.25000, -109.75000);
        mMap.addMarker(new MarkerOptions().position(bcs).title("Baja California Sur, México"));

        LatLng ag = new LatLng(21.8823400, -102.2825900);
        mMap.addMarker(new MarkerOptions().position(ag).title("Aguascalientes, México"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 3.0f ) );
    }
}

