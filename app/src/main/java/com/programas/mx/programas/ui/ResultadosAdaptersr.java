package com.programas.mx.programas.ui;

/**
 * Created by ariaocho on 02/10/18.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.programas.mx.programas.DetalleActivity;
import com.programas.mx.programas.MainActivity;
import com.programas.mx.programas.R;
import com.programas.mx.programas.domain.Programas;


import java.util.ArrayList;


public class ResultadosAdaptersr extends RecyclerView.Adapter<ResultadosAdaptersr.ViewHolder> {

    private ArrayList<Programas> resultados;
    private int itemLayout;
    Context context;

    private static String LOG_TAG = "CardViewActivity";

    public ResultadosAdaptersr(ArrayList<Programas> resultados, int itemLayout, Context context) {
        this.context = context;
        this.resultados = resultados;
        this.itemLayout = itemLayout;
        //addAll(cobros);
        Log.e(LOG_TAG, String.valueOf(resultados.size()));

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(v);   //es el viewHolder creado abajo

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Programas resultado = resultados.get(i);

        viewHolder.lprograma.setText(resultado.getPrograma());
        viewHolder.lbeneficiarios.setText(resultado.getBeneficiarios());
        viewHolder.ldependencia.setText(resultado.getDependencia());

        // set listeners a los botones
        viewHolder.setOnClickListeners();


    }


    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public void addAll(@NonNull ArrayList<Programas> resultados) {
        if (resultados == null)
            throw new NullPointerException("La lista no puede ser vacia");
        this.resultados = resultados;
        /*notificar al recycler view que los datos ahn cambiado*/
        notifyItemRangeInserted(getItemCount() - 1, resultados.size());
        /* o tambien notifyDataSetChanged(); */
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView lprograma;
        public TextView ldependencia;
        public TextView lbeneficiarios;


        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            lprograma = (TextView) itemView.findViewById(R.id.id_text);
            lbeneficiarios = (TextView) itemView.findViewById(R.id.cifra);
            ldependencia = (TextView) itemView.findViewById(R.id.content);


           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {




                }
            });*/
        }

        void setOnClickListeners(){
            lprograma.setOnClickListener(this);
            lbeneficiarios.setOnClickListener(this);
            ldependencia.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (lprograma.getText().toString().equals("Programa de Infraestructura")) {
                switch (view.getId()) {

                    case R.id.id_text:
                        //int pos = getAdapterPosition();
                        //String cp = resultados.get(pos).getClave_catastral();
                        //Log.e("ID",String.valueOf(view.getId()));
                        Intent intentc = new Intent(context, DetalleActivity.class);
                        intentc.putExtra("clave", lprograma.getText().toString());
                        context.startActivity(intentc);
                        break;
                    case R.id.content:
                        Intent intentv = new Intent(context, DetalleActivity.class);
                        intentv.putExtra("clave", lprograma.getText().toString());
                        intentv.putExtra("cp", lbeneficiarios.getText().toString());
                        context.startActivity(intentv);
                        break;

                    case R.id.dependencia:
                        Intent intentd = new Intent(context, DetalleActivity.class);
                        intentd.putExtra("clave", lprograma.getText().toString());
                        intentd.putExtra("cp", lbeneficiarios.getText().toString());
                        context.startActivity(intentd);
                        break;

                }
                ((Activity) context).finish();
            }
        }
    }

}
