package com.SCT.mx.SCT;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.Gravity;
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

import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.SCT.mx.SCT.domain.ProgramasBeneficiarios;
import com.SCT.mx.SCT.domain.ProgramasInversion;
import com.SCT.mx.SCT.ui.ResultadosAdapter;
import com.SCT.mx.SCT.ui.ResultadosAdapterI;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.programas.mx.programas.R;


public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener, OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;
    private GoogleMap mMap;
    private Marker marker_mx;

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


        //fAB
        //primero

        FloatingActionButton fabp = (FloatingActionButton) findViewById(R.id.fab_p);
        fabp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("FAB","p");
                Intent intent = new Intent(MainActivity.this, Infraestructura.class);
                startActivity(intent);
            }
        });

        //cuarto
        FloatingActionButton fabc = (FloatingActionButton) findViewById(R.id.fab_c);
        fabc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("FAB","p");
                Intent intent = new Intent(MainActivity.this, Anticorrupcion.class);
                startActivity(intent);
            }
        });

        // inicia chart1
        LineChart bchart1 = (LineChart) findViewById(R.id.bchart1);


        ArrayList<Entry> yVals11 = new ArrayList<Entry>();

        //for (int i = (int) 0; i < 10 + 1; i++) {
        //    float val = (float) (Math.random());
        //    yVals1.add(new BarEntry(i, val));
        //}

        yVals11.add(new Entry(0,0F));
        yVals11.add(new Entry(1,56.5F));
        yVals11.add(new Entry(2,184.3F));
        yVals11.add(new Entry(3,14.34F));
        yVals11.add(new Entry(4,56.23F));
        yVals11.add(new Entry(5,12.45F));
        yVals11.add(new Entry(6,21.65F));
        yVals11.add(new Entry(7,76.45F));
        yVals11.add(new Entry(8,76.34F));
        yVals11.add(new Entry(9,87.34F));

        LineDataSet set11;

        set11 = new LineDataSet(yVals11, "Inversión en Obras a 2018");
        set11.setColors(ColorTemplate.MATERIAL_COLORS);
        //set11.setColor(Color.BLACK);
        set11.setCircleColor(Color.BLACK);
        set11.setLineWidth(1f);
        set11.setCircleRadius(3f);
        set11.setDrawCircleHole(false);
        set11.setValueTextSize(9f);
        //set11.setDrawFilled(true);

        ArrayList<LineDataSet> dataSets1 = new ArrayList<LineDataSet>();
        dataSets1.add(set11);

        /*ArrayList <String> labels = new ArrayList<String>();
        labels.add("Aguascalientes");
        labels.add("Baja California");
        labels.add("Baja California Sur");
        labels.add("Campeche");
        labels.add("Coahuila");
        labels.add("Colima");
        labels.add("Chiapas");
        labels.add("Ciudad de México");
        labels.add("Durango");
        labels.add("Guanajuato");
        labels.add("Guerrero");
        labels.add("Hidalgo");
        labels.add("Jalisco");
        labels.add("Michoacan");
        labels.add("Puebla");*/



        //
        //****
        // Controlling X axis
        XAxis xAxis = bchart1.getXAxis();
        // Set the xAxis position to bottom. Default is top
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        //Customizing x axis value
        final String[] months = new String[]{"","AGS", "BC", "BCS", "CAM", "COH","COL","CHI","CDMX"}; //,"DUR","GTO","GRO","HGO","JAL","MICH","PU"};

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return months[(int) value];
            }
        };
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);

        //***
        // Controlling right side of y axis
        YAxis yAxisRight = bchart1.getAxisRight();
        yAxisRight.setEnabled(true);

        //***
        // Controlling left side of y axis
        YAxis yAxisLeft = bchart1.getAxisLeft();
        yAxisLeft.setGranularity(1f);
        //

        LineData data1= new LineData(set11);

        data1.setValueTextSize(10f);
        //data1.setBarWidth(0.9f);


        bchart1.setTouchEnabled(true);
        bchart1.setData(data1);
        bchart1.setDrawGridBackground(false);
        bchart1.setScaleEnabled(true);
        bchart1.setDragEnabled(true);
        bchart1.animateX(2500);
        //bchart1.setVisibleXRangeMaximum(10);


        //bchart1.setDrawValueAboveBar(true);

        Legend l1 = bchart1.getLegend();
        l1.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l1.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l1.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l1.setForm(Legend.LegendForm.SQUARE);
        l1.setDrawInside(true);
        l1.setXEntrySpace(0f);
        l1.setYEntrySpace(0f);
        l1.setYOffset(0f);



        // inicia chart
        BarChart bchart = (BarChart) findViewById(R.id.bchart);


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
        set1.setStackLabels(new String[]{"En Proyecto", "En Proceso", "Asignadas"});

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
        bchart.getDescription().setEnabled(true);
        bchart.getDescription().setText("Licitaciones 2018");



        bchart.setDrawValueAboveBar(false);

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


        //chart contratos
        //chart
        PieChart bchart4 = (PieChart) findViewById(R.id.bchart4);

        List<PieEntry> entries4 = new ArrayList<>();



        entries4.add(new PieEntry(456f, "Menor a 5 M"));
        entries4.add(new PieEntry(765f, "Mayor a 5 M"));


        /*entries3.add(new PieEntry(1.33f,"Apoyo al Estudiante"));
        entries3.add(new PieEntry(1.00f,"Atención salud Visual"));
        entries3.add(new PieEntry(0.97f,"Premio Estatal a la Juventud"));
        entries3.add(new PieEntry(0.75f,"Mejoramiento de Vivienda"));
        entries3.add(new PieEntry(0.68f,"Programa de Apoyo a Pequeños Productores"));
        entries3.add(new PieEntry(0.57f,"Apoyo a la Población Indígena"));
        entries3.add(new PieEntry(0.50f,"Apoyo a Mujeres Jefas de Familia"));
        entries3.add(new PieEntry(0.45f,"Formación del Sector Artesanal"));
        entries3.add(new PieEntry(0.43f,"Proyectos Productivos"));*/

        PieDataSet set4 = new PieDataSet(entries4, "Número de Contratos");
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
        bchart4.getLegend().setEnabled(false);
        bchart4.getDescription().setText("Número de contratos" );


        Legend l3 = bchart4.getLegend();
        l3.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l3.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l3.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l3.setDrawInside(false);
        l3.setXEntrySpace(2f);
        l3.setYEntrySpace(2f);
        l3.setYOffset(0f);
        l3.setWordWrapEnabled(true);
        l3.setTextSize(5f);

        //

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

        xAxis.setLabelCount(4);


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


        //+++++


      /*final String[] dfg = new String[]{"Radio Federal","Televisión Civil", "Telefonía", "Internet"};

        IAxisValueFormatter frm = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return dfg[(int) value];
            }
        };

        xAxis.setValueFormatter(frm);
*/


        yr.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//        yr.setInverted(true);

        float barWidth = 0.7f;
        float spaceForBar = 10f;

        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();

        //for (int i = (int) 0; i < 10 + 1; i++) {
        //    float val = (float) (Math.random());
        //    yVals2.add(new BarEntry(i, val));
        //}

        yVals2.add(new BarEntry(4,7.28F,"Radio Federal"));
        yVals2.add(new BarEntry(3,13.50F,"Televisión Civil"));
        yVals2.add(new BarEntry(1,23.70F,"Telefonía"));
        yVals2.add(new BarEntry(2,18.50F,"Internet"));

        BarDataSet set2;

        set2 = new BarDataSet(yVals2, "Inversión Total en Comunicaciones");

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
        arregloPB.add(new ProgramasBeneficiarios("Autotransporte Federal","$ 50.346,578.00"));
        arregloPB.add(new ProgramasBeneficiarios("Aeronáutica Civil", "$ 81,300,643.00"));
        arregloPB.add(new ProgramasBeneficiarios("Desarrollo Ferroviario", "$ 90,800,000.00"));
        arregloPB.add(new ProgramasBeneficiarios("Transporte Marítimo","31,330,635.00"));

        datasetPB = new ArrayList<ProgramasBeneficiarios>();
        datasetPB = arregloPB;
        recyclerView = (RecyclerView) findViewById(R.id.rv_beneficiarios);
        recyclerView.setHasFixedSize(true);
        adapter = new ResultadosAdapter(datasetPB, R.layout.item_list_contentt, MainActivity.this);//(cobroarraylist, R.layout.cobrador_item_lista);
        //recyclerView.setAdapter(new CobroAdapter(cobroarraylist, R.layout.cobrador_item_lista));  //cobroarraylist
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //inicia top programas vs inversión



        //chart  TRANSPORTE
        PieChart bchart3 = (PieChart) findViewById(R.id.bchart2);

        List<PieEntry> entries3 = new ArrayList<>();



        entries3.add(new PieEntry(50.34f, "Autotransporte Federal"));
        entries3.add(new PieEntry(81.30f, "Aeronáutica Civil"));
        entries3.add(new PieEntry(90.8f, "Desarrollo Ferroviario"));
        entries3.add(new PieEntry(31.33f, "Transporte Marítimo"));

        /*entries3.add(new PieEntry(1.33f,"Apoyo al Estudiante"));
        entries3.add(new PieEntry(1.00f,"Atención salud Visual"));
        entries3.add(new PieEntry(0.97f,"Premio Estatal a la Juventud"));
        entries3.add(new PieEntry(0.75f,"Mejoramiento de Vivienda"));
        entries3.add(new PieEntry(0.68f,"Programa de Apoyo a Pequeños Productores"));
        entries3.add(new PieEntry(0.57f,"Apoyo a la Población Indígena"));
        entries3.add(new PieEntry(0.50f,"Apoyo a Mujeres Jefas de Familia"));
        entries3.add(new PieEntry(0.45f,"Formación del Sector Artesanal"));
        entries3.add(new PieEntry(0.43f,"Proyectos Productivos"));*/

        PieDataSet set3 = new PieDataSet(entries3, "Millones de Inversión en Transporte");
        PieData data3 = new PieData(set3);
        bchart3.setData(data3);
        bchart3.invalidate(); // refresh

        set3.setColors(ColorTemplate.MATERIAL_COLORS);

        data3.setValueTextSize(15f);
        data3.setValueTextColor(Color.DKGRAY);

        // data.setBarWidth(0.9f);

        bchart3.setTouchEnabled(true);
        bchart3.setData(data3);
        bchart3.setDrawEntryLabels(false);
        bchart3.setEntryLabelColor(Color.BLACK);
        bchart3.setDrawEntryLabels(true);
        bchart3.setEntryLabelTextSize(8f);
        bchart3.getLegend().setEnabled(false);
        bchart3.getDescription().setText("Millones de pesos invertidos en transporte" );


        /*Legend l3 = bchart3.getLegend();
        l3.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l3.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l3.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l3.setDrawInside(false);
        l3.setXEntrySpace(2f);
        l3.setYEntrySpace(2f);
        l3.setYOffset(0f);
        l3.setWordWrapEnabled(true);
        l3.setTextSize(5f);*/






        //RV

        ArrayList<ProgramasInversion> arregloPI = new ArrayList<>();




        arregloPI.add(new ProgramasInversion("Radio Federal", "$ 7,286,278.00"));

        arregloPI.add(new ProgramasInversion("Televisión Civil", "$ 13,576,588.00"));

        arregloPI.add(new ProgramasInversion("Internet", "$ 18,506,256.00"));
        arregloPI.add(new ProgramasInversion("Telefonía", "$ 23,776,538.00"));
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
        mMap.addMarker(new MarkerOptions().position(mexico).title("Ciudad de México, México").snippet(" Obras: 959  "+ "\n Inversión: $145,248,369.00"));

        LatLng bc = new LatLng(32.6519, -115.4683);
        mMap.addMarker(new MarkerOptions().position(bc).title("Baja California, México").snippet(" Obras: 355  "+ "\n Inversión: $286,274,435.00"));

        LatLng bcs = new LatLng(23.25000, -109.75000);
        mMap.addMarker(new MarkerOptions().position(bcs).title("Baja California Sur, México").snippet(" Obras: 54  "+ "\n Inversión: $34,639,174.00"));

        LatLng ag = new LatLng(21.8823400, -102.2825900);
        mMap.addMarker(new MarkerOptions().position(ag).title("Aguascalientes, México").snippet(" Obras: 584  "+ "\n Inversión: $321,584,274.00"));

        LatLng ch = new LatLng(16.75, -93.1167);
        mMap.addMarker(new MarkerOptions().position(ch).title("Chiapas, México").snippet(" Obras: 843  "+ "\n Inversión: $74,747,739.00"));

        LatLng gr = new LatLng(18.775, -103.8375);
        mMap.addMarker(new MarkerOptions().position(gr).title("Colima, México").snippet(" Obras: 585  "+ "\n Inversión: $23,004,942.00"));

        LatLng cam = new LatLng(19.8454,-90.5237);
        mMap.addMarker(new MarkerOptions().position(cam).title("Campeche, México").snippet(" Obras: 463  "+ "\n Inversión: $75,754,725.00"));

        LatLng ver = new LatLng(19.1809500,-96.1429000);
        mMap.addMarker(new MarkerOptions().position(ver).title("Veracruz, México").snippet(" Obras: 245  "+ "\n Inversión: $1,245,642.00"));


        LatLng chi = new LatLng(28.6352800,-106.0888900);
        mMap.addMarker(new MarkerOptions().position(chi).title("Chihuahua, México").snippet(" Obras: 742  "+ "\n Inversión: $75,5768,235.00"));

        LatLng sin = new LatLng( 27.35,-102.0167);
        mMap.addMarker(new MarkerOptions().position(sin).title("Sinaloa, México").snippet(" Obras: 325  "+ "\n Inversión: $24,634,460.00"));

        LatLng ger = new LatLng( 16.775,-93.7417);
        mMap.addMarker(new MarkerOptions().position(sin).title("Guerrero, México").snippet(" Obras: 753 "+ "\n Inversión: $10,743,074.00"));


        LatLng center = new LatLng( 22.6526121, -100.1780452);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 4.0f ) );




        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            /**
             * handle marker click event
             */
            @Override
            public boolean onMarkerClick(Marker marker) {
                // TODO Auto-generated method stub

                Log.w("Click", marker.getTitle().toString());

                if(marker.getTitle().toString().equals("Ciudad de México, México")){

                    //Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    //intent.putExtra("estado","cdmx");
                    //startActivity(intent);
                }
                if(marker.equals(marker_mx)){
                    Log.w("Click", "MX");
                    return true;
                }


                mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                    @Override
                    public View getInfoWindow(Marker arg0) {
                        return null;
                    }

                    @Override
                    public View getInfoContents(Marker marker) {

                        LinearLayout info = new LinearLayout(MainActivity.this);
                        info.setOrientation(LinearLayout.VERTICAL);

                        TextView title = new TextView(MainActivity.this);
                        title.setTextColor(Color.BLACK);
                        title.setGravity(Gravity.CENTER);
                        title.setTypeface(null, Typeface.BOLD);
                        title.setText(marker.getTitle());

                        TextView snippet = new TextView(MainActivity.this);
                        snippet.setTextColor(Color.GRAY);
                        snippet.setText(marker.getSnippet());

                        info.addView(title);
                        info.addView(snippet);

                        return info;
                    }
                });

                return false;


            }
        });




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

