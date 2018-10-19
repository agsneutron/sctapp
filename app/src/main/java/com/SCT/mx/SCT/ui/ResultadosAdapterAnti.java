package com.SCT.mx.SCT.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.SCT.mx.SCT.domain.AnticorrupcionModel;
import com.programas.mx.programas.R;


import java.util.ArrayList;
/**
 * Created by bamaa on 19/10/18.
 */

public class ResultadosAdapterAnti extends RecyclerView.Adapter<ResultadosAdapterAnti.ViewHolder>{

    private ArrayList<AnticorrupcionModel> resultados;
    private int itemLayout;
    Context context;

    private static String LOG_TAG = "CardViewActivity";

    public ResultadosAdapterAnti(ArrayList<AnticorrupcionModel> resultados, int itemLayout, Context context) {
        this.context = context;
        this.resultados = resultados;
        this.itemLayout = itemLayout;
        //addAll(cobros);
        Log.e(LOG_TAG, String.valueOf(resultados.size()));

    }

    @Override
    public ResultadosAdapterAnti.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ResultadosAdapterAnti.ViewHolder(v);   //es el viewHolder creado abajo

    }

    @Override
    public void onBindViewHolder(ResultadosAdapterAnti.ViewHolder viewHolder, int i) {

        AnticorrupcionModel resultado = resultados.get(i);

        viewHolder.lprograma.setText(resultado.getNombre());
        viewHolder.lbeneficiarios.setText(resultado.getEstatus());
        viewHolder.l2.setText(resultado.getNo_contrato());
        viewHolder.l3.setText(resultado.getInversion());

        // set listeners a los botones
        viewHolder.setOnClickListeners();


    }


    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public void addAll(@NonNull ArrayList<AnticorrupcionModel> resultados) {
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
        public TextView l2;
        public TextView l3;


        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            lprograma = (TextView) itemView.findViewById(R.id.id_text);
            lbeneficiarios = (TextView) itemView.findViewById(R.id.content);
            l2 = (TextView) itemView.findViewById(R.id.content1);
            l3= (TextView) itemView.findViewById(R.id.content2);


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
