package com.SCT.mx.SCT.domain;

/**
 * Created by bamaa on 19/10/18.
 */

public class AnticorrupcionModel {

    String nombre;
    String estatus;
    String no_contrato;
    String inversion;

    public AnticorrupcionModel() {
    }

    public AnticorrupcionModel(String nombre, String estatus, String no_contrato, String inversion) {
        this.nombre = nombre;
        this.estatus = estatus;
        this.no_contrato = no_contrato;
        this.inversion = inversion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNo_contrato() {
        return no_contrato;
    }

    public void setNo_contrato(String no_contrato) {
        this.no_contrato = no_contrato;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }
}
