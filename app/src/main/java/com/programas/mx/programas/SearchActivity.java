package com.programas.mx.programas;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class SearchActivity extends AppCompatActivity implements OnMapReadyCallback {

    SearchableSpinner estado;
    SearchableSpinner municipio;
    SearchableSpinner dependencia;
    SearchableSpinner programa;
    String[] mpos = new String[] {"Selecciona Municipio"};

    //MAPA

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //MAPA
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        estado = findViewById(R.id.estado);
        municipio = findViewById(R.id.municipio);
        dependencia = findViewById(R.id.dependencia);
        programa = findViewById(R.id.programa);

        estado.setTitle("Seleciona Estado");
        estado.setPositiveButton("OK");

        municipio.setTitle("Seleciona Municipio");
        municipio.setPositiveButton("OK");

        dependencia.setTitle("Seleciona Dependencia");
        dependencia.setPositiveButton("OK");

        programa.setTitle("Seleciona Programa");
        programa.setPositiveButton("OK");

        String[] edos = new String[] {"Selecciona Estado", "Aguascalientes", "Baja California Norte", "Baja California Sur","Ciudad de México"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, edos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estado.setAdapter(adapter);

        estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                //items[0] = "One";
                //selectedItem = items[position];
                Log.e("Posicion",String.valueOf(position));
                switch (position){
                    case 0:
                        mpos = new String[] {"Selecciona Municipio"};
                        break;
                    case 1:
                        mpos = new String[] {"Selecciona Municipio", "Aguascalientes",
                                "Asientos",
                                "Calvillo",
                                "Cosío",
                                "El Llano",
                                "Jesús María",
                                "Pabellón de Arteaga" ,
                                "Rincón de Romos" ,
                                "San Francisco de los Romo" ,
                                "San José de Gracia" ,
                                "Tepezalá"
                        };
                        break;
                    case 2:
                        mpos= new String[] {"Selecciona Municipio","Ensenada" ,
                                "Mexicali" ,
                                "Playas de Rosarito" ,
                                "Tecate", "Tijuana"
                        };
                        break;

                    case 3:
                        mpos= new String[] {"Selecciona Municipio","Comondú" ,
                                "La Paz" ,
                                "Loreto" ,
                                "Los Cabos",
                                "Mulegé"
                        };
                        break;

                    case 4:
                        mpos = new String[] {"Selecciona Municipio", " Alvaro Obregón" , " Azcapotzalco" , " Benito Juárez" ,
                                " Coyoacán" , " Cuahutémoc" , " Cuajimalpa" , " Gustavo A. Madero" , " Iztacalco" , " Iztapalapa" ,
                                " Magdalena Contreras" , " Miguel Hidalgo" , " Milpa Alta" , " Tlahuac" , " Tlalpan" , " Venustiano Carranza" ,
                                " Xochimilco"};
                        break;
                    default:
                        mpos = new String[] {"Selecciona Municipio"};

                }

                ArrayAdapter<String> adapterM = new ArrayAdapter<String>(SearchActivity.this, android.R.layout.simple_spinner_item, mpos);
                adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                municipio.setAdapter(adapterM);


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }


        });



        municipio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                //items[0] = "One";
                //selectedItem = items[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        String[] prog = new String[] {"Selecciona Programa","Apoyo a la Población Vulnerable",
                "Nutrición con Valor",
                "Tu Empleo Formal",
                "Asistencia Social a la Comunidad",
                "Apoyo al Estudiante",
                "Apoyo a Mujeres Jefas de Familia",
                "Formación del Sector Artesanal",
                "Proyectos Productivos",
                "Apoyo a Asociaciones Culturales",
                "Beca Deportiva",
                "Atención salud Visual",
                "Premio Estatal a la Juventud",
                "Mejoramiento de Vivienda",
                "Programa de Apoyo a Pequeños Prroductores",
                "Apoyo a la Población Indígena"
        };

        ArrayAdapter<String> adapterP = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, prog);
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        programa.setAdapter(adapterP);

        programa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                //items[0] = "One";
                //selectedItem = items[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        String[] dep = new String[]{"Selecciona Dependencia",
                "Secretaría de Relaciones Exteriores (SRE)",
                "Secretaría de Salud (SSA)",
                "Secretaría de Turismo (SECTUR)",
                "Secretaría del Trabajo y Previsión Social (STPS)",
                "Secretaría General del Consejo Nacional de Población (CONAPO)",
                "Comisión Nacional de Seguros y Fianzas (CNSF)",
                "Comisión Nacional de Vivienda (CONAVI)",
                "Comisión Nacional de Zonas Áridas (CONAZA)",
                "Instituto Nacional para la Educación de Adultos (INEA)",
        };

        ArrayAdapter<String> adapterD = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dep);
        adapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dependencia.setAdapter(adapterD);

        dependencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                //items[0] = "One";
                //selectedItem = items[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });





        // inicia chart
        PieChart bchart = (PieChart) findViewById(R.id.bchart);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(18.5f, "Nutrición con Valor"));
        entries.add(new PieEntry(26.7f, "Atención salud Visual"));
        entries.add(new PieEntry(24.0f, "Mejoramiento de Vivienda"));
        entries.add(new PieEntry(30.8f, "Apoyo al Estudiante"));

        PieDataSet set = new PieDataSet(entries, "Miles de Beneficiarios por Programa");
        PieData data = new PieData(set);
        bchart.setData(data);
        bchart.invalidate(); // refresh


        set.setColors(ColorTemplate.MATERIAL_COLORS);

        data.setValueTextSize(20f);
        data.setValueTextColor(Color.DKGRAY);
       // data.setBarWidth(0.9f);

        bchart.setTouchEnabled(true);
        bchart.setData(data);
        bchart.setEntryLabelTextSize(10f);
        bchart.setEntryLabelColor(Color.BLACK);
        bchart.setDrawEntryLabels(true);

        Legend l = bchart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);


        //inicia mapa




        // inicia datos

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(19.4326009, -99.1333416);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Ciudad de México, México"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}
