package com.SCT.mx.SCT.ui;

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
import com.SCT.mx.SCT.domain.ProgramaOb;
import com.SCT.mx.SCT.domain.ProgramasBeneficiarios;
import com.programas.mx.programas.R;

import java.util.ArrayList;

/**
 * Created by ariaocho on 18/10/18.
 */

public class ResultadosAdapterx extends RecyclerView.Adapter<ResultadosAdapterx.ViewHolder> {

    private ArrayList<ProgramaOb> resultados;
    private int itemLayout;
    Context context;

    private static String LOG_TAG = "CardViewActivity";

    public ResultadosAdapterx(ArrayList<ProgramaOb> resultados, int itemLayout, Context context) {
        this.context = context;
        this.resultados = resultados;
        this.itemLayout = itemLayout;
        //addAll(cobros);
        Log.e(LOG_TAG, String.valueOf(resultados.size()));

    }

    @Override
    public ResultadosAdapterx.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ResultadosAdapterx.ViewHolder(v);   //es el viewHolder creado abajo

    }

    @Override
    public void onBindViewHolder(ResultadosAdapterx.ViewHolder viewHolder, int i) {

        ProgramaOb resultado = resultados.get(i);

        viewHolder.lprograma.setText(resultado.getNombre());
        viewHolder.lbeneficiarios.setText(resultado.getMeta_total());
        viewHolder.l3.setText(resultado.getAvance_total());
        viewHolder.l4.setText(resultado.getAvance_unidades());
        viewHolder.l5.setText(resultado.getAvance_porcentaje());
        viewHolder.l6.setText(resultado.getAvance_importe());

        // set listeners a los botones
        viewHolder.setOnClickListeners();


    }


    @Override
    public int getItemCount() {
        return resultados.size();
    }

    public void addAll(@NonNull ArrayList<ProgramaOb> resultados) {
        if (resultados == null)
            throw new NullPointerException("La lista no puede ser vacia");
        this.resultados = resultados;
        /*notificar al recycler view que los datos ahn cambiado*/
        notifyItemRangeInserted(getItemCount() - 1, resultados.size());
        /* o tambien notifyDataSetChanged(); */
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView lprograma;
        public TextView lbeneficiarios,l2,l3,l5,l4,l6;



        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            lprograma = (TextView) itemView.findViewById(R.id.id_text);
            lbeneficiarios = (TextView) itemView.findViewById(R.id.t2);
            l3 = (TextView) itemView.findViewById(R.id.t3);
            l4 = (TextView) itemView.findViewById(R.id.t4);
            l5 = (TextView) itemView.findViewById(R.id.t5);
            l6 =(TextView) itemView.findViewById(R.id.t6);


           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {




                }
            });*/
        }

        void setOnClickListeners() {
            lprograma.setOnClickListener(this);
            lbeneficiarios.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.id_text:
                    if (lprograma.getText().toString().equals("Carretera-ULUMAL-VILLA DE GUADALUPE")){
                        //int pos = getAdapterPosition();
                        //String cp = resultados.get(pos).getClave_catastral();
                        Log.e("ID", String.valueOf(view.getId()));
                    Intent intentc = new Intent(context, FichaTecnica.class);
                    intentc.putExtra("clave", lprograma.getText().toString());
                    context.startActivity(intentc);
                    }
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
