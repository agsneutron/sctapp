package com.SCT.mx.SCT;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.SCT.mx.SCT.domain.ProgramaOb;
import com.SCT.mx.SCT.domain.ProgramasBeneficiarios;
import com.SCT.mx.SCT.domain.ProgramasInversion;
import com.SCT.mx.SCT.ui.ResultadosAdapter;
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
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.programas.mx.programas.R;

import java.util.ArrayList;
import java.util.List;

public class Infraestructura extends AppCompatActivity implements OnMapReadyCallback {



    ArrayList<ProgramaOb> datasetPB;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    private GoogleMap mMap;
    private Marker marker_mx;

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
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //MAPA
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapINF);
        mapFragment.getMapAsync(this);
        //

        //RV


        //Nombre, Meta_total, avance_total, avance_unidades, avance_porcentaje, avance_importe
        ArrayList<ProgramaOb> arregloOB = new ArrayList<>();
        arregloOB.add(new ProgramaOb("Nombre", "Meta ", "Av. Total", "Av. Unidades", "Av. Porcentaje", "Inversión"));
        arregloOB.add(new ProgramaOb("Carretera-ULUMAL-VILLA DE GUADALUPE","80","76","3100 km","95%","$ 56 MDP"));
        arregloOB.add(new ProgramaOb("Autopistas-1ra SEC TRAMO FEDERAL", "52","38","2400 km","73%","$ 146 MDP"));
        arregloOB.add(new ProgramaOb("Accesos a ZMVM--CONSERVACION DEL CAMINO PEDREGAL ", "10","6","67 km","60%","$ 14 MDP"));
        arregloOB.add(new ProgramaOb("Distribuidores-Dist víal Oriente", "50","50","700 km","100%","$ 12 MDP"));
        arregloOB.add(new ProgramaOb("Caminos rurales-PROLONGACION DE LA ESCOLLERA","36","32","400 km","90%","$ 87 MDP"));
        arregloOB.add(new ProgramaOb("Libramientos-ATENCION AL PUNTO DE CONFLICTO LA PILA", "56","36","944 km","64%","$ 64 MDP"));
        arregloOB.add(new ProgramaOb("Marítimo- MANTENIMIENTO PUERTO MADERO", "53","52","000 TONS","0%","$ 70 MDP"));
        arregloOB.add(new ProgramaOb("Ferroviario-COYUCA I", "8","6","632 km","60","$ 38.5 MDP"));
        arregloOB.add(new ProgramaOb("Carretera-E.C- CHAMP. – CAMP.","80","76","3100 km","95%","$ 56 MDP"));
        arregloOB.add(new ProgramaOb("Autopistas-TRAMO FEDERAL-VILLA DE GUADALUPE", "52","38","2400 km","73%","$ 146 MDP"));
        arregloOB.add(new ProgramaOb("Accesos a ZMVM--CONSERVACION DEL CAMINO PEDREGAL ", "10","6","67 km","60%","$ 14 MDP"));
        arregloOB.add(new ProgramaOb("Distribuidores-Dist víal Oriente", "50","50","700 km","100%","$ 12 MDP"));
        arregloOB.add(new ProgramaOb("Caminos rurales-PROLONGACION DE LA ESCOLLERA","36","32","400 km","32%","$ 90 MDP"));
        arregloOB.add(new ProgramaOb("Libramientos-ATENCION AL PUNTO DE CONFLICTO LA PILA", "56","36","944 km","64%","$ 64 MDP"));
        arregloOB.add(new ProgramaOb("Marítimo- MANTENIMIENTO PUERTO MADERO", "53","52","000 Tons","0 %","$ 80 MDP"));
        arregloOB.add(new ProgramaOb("Ferroviario-COYUCA I", "8","6","632 km","60%","$ 38.5 MDP"));




        datasetPB = new ArrayList<ProgramaOb>();
        datasetPB = arregloOB;
        recyclerView = (RecyclerView) findViewById(R.id.rv_list_inf);
        recyclerView.setHasFixedSize(true);
        adapter = new ResultadosAdapterx(datasetPB, R.layout.item_list_contentx, Infraestructura.this);//(cobroarraylist, R.layout.cobrador_item_lista);
        //recyclerView.setAdapter(new CobroAdapter(cobroarraylist, R.layout.cobrador_item_lista));  //cobroarraylist
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Infraestructura.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        // inicia chart
        BarChart bchart = (BarChart) findViewById(R.id.bchart);


        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        //for (int i = (int) 0; i < 10 + 1; i++) {
        //    float val = (float) (Math.random());
        //    yVals1.add(new BarEntry(i, val));
        //}



        yVals1.add(new BarEntry(1,50.34f, "Autotransporte Federal"));
        yVals1.add(new BarEntry(2,81.30f, "Aeronáutica Civil"));
        yVals1.add(new BarEntry(3,90.8f, "Desarrollo Ferroviario"));
        yVals1.add(new BarEntry(4,31.33f, "Transporte Marítimo"));




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

        set1 = new BarDataSet(yVals1, "Inversión en Obras del 2018");
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
        PieChart bchart4 = (PieChart) findViewById(R.id.bchart4);

        List<PieEntry> entries4 = new ArrayList<>();



        entries4.add(new PieEntry(39764967f, "Redes"));
        entries4.add(new PieEntry(84543987, "Sistemas"));


        /*entries3.add(new PieEntry(1.33f,"Apoyo al Estudiante"));
        entries3.add(new PieEntry(1.00f,"Atención salud Visual"));
        entries3.add(new PieEntry(0.97f,"Premio Estatal a la Juventud"));
        entries3.add(new PieEntry(0.75f,"Mejoramiento de Vivienda"));
        entries3.add(new PieEntry(0.68f,"Programa de Apoyo a Pequeños Productores"));
        entries3.add(new PieEntry(0.57f,"Apoyo a la Población Indígena"));
        entries3.add(new PieEntry(0.50f,"Apoyo a Mujeres Jefas de Familia"));
        entries3.add(new PieEntry(0.45f,"Formación del Sector Artesanal"));
        entries3.add(new PieEntry(0.43f,"Proyectos Productivos"));*/

        PieDataSet set4 = new PieDataSet(entries4, "Inversión en Redes y Sistemas");
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
        bchart4.getDescription().setText("Telecomunicaciones" );


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
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 5.0f ) );




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

                        LinearLayout info = new LinearLayout(Infraestructura.this);
                        info.setOrientation(LinearLayout.VERTICAL);

                        TextView title = new TextView(Infraestructura.this);
                        title.setTextColor(Color.BLACK);
                        title.setGravity(Gravity.CENTER);
                        title.setTypeface(null, Typeface.BOLD);
                        title.setText(marker.getTitle());

                        TextView snippet = new TextView(Infraestructura.this);
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



}
