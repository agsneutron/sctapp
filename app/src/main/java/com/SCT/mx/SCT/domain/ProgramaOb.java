package com.SCT.mx.SCT.domain;

/**
 * Created by ariaocho on 18/10/18.
 */

public class ProgramaOb {
   String  Nombre, Meta_total, avance_total, avance_unidades, avance_porcentaje, avance_importe;


    public ProgramaOb() {

    }


    public ProgramaOb(String nombre, String meta_total, String avance_total, String avance_unidades, String avance_porcentaje, String avance_importe) {
        Nombre = nombre;
        Meta_total = meta_total;
        this.avance_total = avance_total;
        this.avance_unidades = avance_unidades;
        this.avance_porcentaje = avance_porcentaje;
        this.avance_importe = avance_importe;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMeta_total() {
        return Meta_total;
    }

    public void setMeta_total(String meta_total) {
        Meta_total = meta_total;
    }

    public String getAvance_total() {
        return avance_total;
    }

    public void setAvance_total(String avance_total) {
        this.avance_total = avance_total;
    }

    public String getAvance_unidades() {
        return avance_unidades;
    }

    public void setAvance_unidades(String avance_unidades) {
        this.avance_unidades = avance_unidades;
    }

    public String getAvance_porcentaje() {
        return avance_porcentaje;
    }

    public void setAvance_porcentaje(String avance_porcentaje) {
        this.avance_porcentaje = avance_porcentaje;
    }

    public String getAvance_importe() {
        return avance_importe;
    }

    public void setAvance_importe(String avance_importe) {
        this.avance_importe = avance_importe;
    }
}
