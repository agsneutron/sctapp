package com.SCT.mx.SCT.domain;

/**
 * Created by ariaocho on 30/09/18.
 */

public class ProgramasInversion {
    String programas;
    String inversion;

    public ProgramasInversion() {

    }

    public ProgramasInversion(String programas, String inversion) {
        this.programas = programas;
        this.inversion = inversion;
    }

    public String getProgramas() {
        return programas;
    }

    public void setProgramas(String programas) {
        this.programas = programas;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

}
