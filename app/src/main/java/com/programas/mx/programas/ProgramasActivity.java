package com.programas.mx.programas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ProgramasActivity extends MainActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);




    }

    public void buttonClick(View view){
        Intent mintent = new Intent(ProgramasActivity.this, DetalleActivity.class);
        startActivity(mintent);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_programas, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));


            return rootView;
        }


    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).


            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }


    }

    /*
    public void grafica1(){
        // inicia chart

        //CHART

        grafica1();
            grafica2();
            grafica3();

        HorizontalBarChart mChart2 = findViewById(R.id.bchart1 );
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

        //for (int i = (int) 0; i < 10 + 1; i++) {
        //    float val = (float) (Math.random());
        //    yVals2.add(new BarEntry(i, val));
        //}


        yVals2.add(new BarEntry(1,55436,"Aguascalientes"));
        yVals2.add(new BarEntry(2,46290,"Baja California"));
        yVals2.add(new BarEntry(3,40285,"Baja California Sur"));
        yVals2.add(new BarEntry(4,38890,"Campeche"));
        yVals2.add(new BarEntry(5,33296,"Coahuila"));
        yVals2.add(new BarEntry(6,29089,"Colima"));
        yVals2.add(new BarEntry(7,26489,"Chiapas"));
        yVals2.add(new BarEntry(8,25728,"Ciudad de México"));
        yVals2.add(new BarEntry(9,22862,"Durango"));
        yVals2.add(new BarEntry(10,20876,"Guanajuato"));
        yVals2.add(new BarEntry(11,19873,"Guerrero"));
        yVals2.add(new BarEntry(12,18250,"Hidalgo"));
        yVals2.add(new BarEntry(13,18998,"Jalisco"));
        yVals2.add(new BarEntry(14,16480,"Ciudad de México"));
        yVals2.add(new BarEntry(15,15027,"Michoacán"));

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

    }

    public void grafica2(){
        // inicia chart

        //CHART

        HorizontalBarChart mChart2 = findViewById(R.id.bchart2 );
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

        //for (int i = (int) 0; i < 10 + 1; i++) {
        //    float val = (float) (Math.random());
        //    yVals2.add(new BarEntry(i, val));
        //}


        yVals2.add(new BarEntry(1,55436,"Aguascalientes"));
        yVals2.add(new BarEntry(2,46290,"Baja California"));
        yVals2.add(new BarEntry(3,40285,"Baja California Sur"));
        yVals2.add(new BarEntry(4,38890,"Campeche"));
        yVals2.add(new BarEntry(5,33296,"Coahuila"));
        yVals2.add(new BarEntry(6,29089,"Colima"));
        yVals2.add(new BarEntry(7,26489,"Chiapas"));
        yVals2.add(new BarEntry(8,25728,"Ciudad de México"));
        yVals2.add(new BarEntry(9,22862,"Durango"));
        yVals2.add(new BarEntry(10,20876,"Guanajuato"));
        yVals2.add(new BarEntry(11,19873,"Guerrero"));
        yVals2.add(new BarEntry(12,18250,"Hidalgo"));
        yVals2.add(new BarEntry(13,18998,"Jalisco"));
        yVals2.add(new BarEntry(14,16480,"Ciudad de México"));
        yVals2.add(new BarEntry(15,15027,"Michoacán"));

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

    }

    public void grafica3(){
        // inicia chart

        //CHART

        HorizontalBarChart mChart2 = findViewById(R.id.bchart3 );
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

        //for (int i = (int) 0; i < 10 + 1; i++) {
        //    float val = (float) (Math.random());
        //    yVals2.add(new BarEntry(i, val));
        //}


        yVals2.add(new BarEntry(1,55436,"Aguascalientes"));
        yVals2.add(new BarEntry(2,46290,"Baja California"));
        yVals2.add(new BarEntry(3,40285,"Baja California Sur"));
        yVals2.add(new BarEntry(4,38890,"Campeche"));
        yVals2.add(new BarEntry(5,33296,"Coahuila"));
        yVals2.add(new BarEntry(6,29089,"Colima"));
        yVals2.add(new BarEntry(7,26489,"Chiapas"));
        yVals2.add(new BarEntry(8,25728,"Ciudad de México"));
        yVals2.add(new BarEntry(9,22862,"Durango"));
        yVals2.add(new BarEntry(10,20876,"Guanajuato"));
        yVals2.add(new BarEntry(11,19873,"Guerrero"));
        yVals2.add(new BarEntry(12,18250,"Hidalgo"));
        yVals2.add(new BarEntry(13,18998,"Jalisco"));
        yVals2.add(new BarEntry(14,16480,"Ciudad de México"));
        yVals2.add(new BarEntry(15,15027,"Michoacán"));

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

    }*/


}
