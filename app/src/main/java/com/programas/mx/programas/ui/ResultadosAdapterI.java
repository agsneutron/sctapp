package com.programas.mx.programas.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.programas.mx.programas.MainActivity;
import com.programas.mx.programas.R;
import com.programas.mx.programas.domain.ProgramasInversion;

import java.util.ArrayList;

/**
 * Created by ariaocho on 30/09/18.
 */

public class ResultadosAdapterI extends RecyclerView.Adapter<ResultadosAdapterI.ViewHolder>{

    private ArrayList<ProgramasInversion> resultados;
    private int itemLayout;
    Context context;
    ProgressDialog progressDialog;

    private static String LOG_TAG = "CardViewActivity";

    public ResultadosAdapterI(ArrayList<ProgramasInversion> resultados, int itemLayout, Context context) {
        this.context = context;
        this.resultados = resultados;
        this.itemLayout = itemLayout;

        Log.e(LOG_TAG, String.valueOf(resultados.size()));

    }

    @Override
    public ResultadosAdapterI.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ResultadosAdapterI.ViewHolder(v);   //es el viewHolder creado abajo

    }

    @Override
    public void onBindViewHolder(ResultadosAdapterI.ViewHolder viewHolder, int i) {

        ProgramasInversion resultado = resultados.get(i);

        viewHolder.lprog.setText(resultado.getProgramas());
        viewHolder.linv.setText(resultado.getInversion());


    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public void addAll(@NonNull ArrayList<ProgramasInversion> resultados) {
        if (resultados == null)
            throw new NullPointerException("La lista no puede ser vacia");
        this.resultados = resultados;
        /*notificar al recycler view que los datos ahn cambiado*/
        notifyItemRangeInserted(getItemCount() - 1, resultados.size());
        /* o tambien notifyDataSetChanged(); */
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView lprog;
        public TextView linv;

        public ViewHolder(View itemView) {
            super(itemView);

            lprog = (TextView) itemView.findViewById(R.id.id_text);
            linv = (TextView) itemView.findViewById(R.id.content);


        }

    }
}
