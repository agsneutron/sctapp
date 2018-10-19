package com.SCT.mx.SCT.ui;

/**
 * Created by ariaocho on 30/09/18.
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

import com.SCT.mx.SCT.FichaTecnica;
import com.SCT.mx.SCT.domain.ProgramasBeneficiarios;
import com.SCT.mx.SCT.MainActivity;
import com.programas.mx.programas.R;


import java.util.ArrayList;


public class ResultadosAdapter extends RecyclerView.Adapter<ResultadosAdapter.ViewHolder> {

    private ArrayList<ProgramasBeneficiarios> resultados;
    private int itemLayout;
    Context context;

    private static String LOG_TAG = "CardViewActivity";

    public ResultadosAdapter(ArrayList<ProgramasBeneficiarios> resultados, int itemLayout, Context context) {
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

        ProgramasBeneficiarios resultado = resultados.get(i);

        viewHolder.lprograma.setText(resultado.getPrograma());
        viewHolder.lbeneficiarios.setText(resultado.getBeneficiarios());

        // set listeners a los botones
        viewHolder.setOnClickListeners();


    }


    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public void addAll(@NonNull ArrayList<ProgramasBeneficiarios> resultados) {
        if (resultados == null)
            throw new NullPointerException("La lista no puede ser vacia");
        this.resultados = resultados;
        /*notificar al recycler view que los datos ahn cambiado*/
        notifyItemRangeInserted(getItemCount() - 1, resultados.size());
        /* o tambien notifyDataSetChanged(); */
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView lprograma;
        public TextView lbeneficiarios;


        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            lprograma = (TextView) itemView.findViewById(R.id.id_text);
            lbeneficiarios = (TextView) itemView.findViewById(R.id.content);


           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {




                }
            });*/
        }

        void setOnClickListeners(){
            lprograma.setOnClickListener(this);
            lbeneficiarios.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.id_text:
                    //int pos = getAdapterPosition();
                    //String cp = resultados.get(pos).getClave_catastral();
                    //Log.e("ID",String.valueOf(view.getId()));
                    //Intent intentc = new Intent(context, FichaTecnica.class);
                    //intentc.putExtra("clave", lprograma.getText().toString());
                    //context.startActivity(intentc);
                    break;
                case R.id.content:
                    //Intent intentv = new Intent(context, MainActivity.class);
                    //intentv.putExtra("clave", lprograma.getText().toString());
                    //intentv.putExtra("cp",lbeneficiarios.getText().toString());
                    //context.startActivity(intentv);
                    break;
            }
            //((Activity)context).finish();
        }
    }
}