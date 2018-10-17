package com.SCT.mx.SCT.domain;

/**
 * Created by ariaocho on 30/09/18.
 */

public class ProgramasBeneficiarios {
    String programa;
    String beneficiarios;

    public ProgramasBeneficiarios() {
    }

    public ProgramasBeneficiarios(String programa, String beneficiarios) {
        this.programa = programa;
        this.beneficiarios = beneficiarios;
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
}
