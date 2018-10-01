package com.programas.mx.programas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.ArrayList;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        // Here, a BarChart is initialized from xml
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