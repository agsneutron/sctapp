package com.SCT.mx.SCT.domain;

/**
 * Created by ariaocho on 02/10/18.
 */

public class Programas {
    String programa;
    String beneficiarios;
    String dependencia;
    String inversion;
    String descripcion;
    String tipo_beneficio;
    String estado;


    public Programas() {
    }

    public Programas(String programa, String beneficiarios, String dependencia, String inversion, String descripcion, String tipo_beneficio, String estado) {
        this.programa = programa;
        this.beneficiarios = beneficiarios;
        this.dependencia = dependencia;
        this.inversion = inversion;
        this.descripcion = descripcion;
        this.tipo_beneficio = tipo_beneficio;
        this.estado = estado;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(String beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_beneficio() {
        return tipo_beneficio;
    }

    public void setTipo_beneficio(String tipo_beneficio) {
        this.tipo_beneficio = tipo_beneficio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
