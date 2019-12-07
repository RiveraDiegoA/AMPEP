package com.riveraprojects.ampep.Models;

import java.util.Date;

public class DocumentoRequisitoColegio {

    private int idDocumetoRequesitoColegio;
    private Date fecregisDocumetoRequesitoColegio;
    private int estadoDocumetoRequesitoColegio;
    private Colegio colegioDocumetoRequesitoColegio;

    public int getIdDocumetoRequesitoColegio() {
        return idDocumetoRequesitoColegio;
    }

    public void setIdDocumetoRequesitoColegio(int idDocumetoRequesitoColegio) {
        this.idDocumetoRequesitoColegio = idDocumetoRequesitoColegio;
    }

    public Date getFecregisDocumetoRequesitoColegio() {
        return fecregisDocumetoRequesitoColegio;
    }

    public void setFecregisDocumetoRequesitoColegio(Date fecregisDocumetoRequesitoColegio) {
        this.fecregisDocumetoRequesitoColegio = fecregisDocumetoRequesitoColegio;
    }

    public int getEstadoDocumetoRequesitoColegio() {
        return estadoDocumetoRequesitoColegio;
    }

    public void setEstadoDocumetoRequesitoColegio(int estadoDocumetoRequesitoColegio) {
        this.estadoDocumetoRequesitoColegio = estadoDocumetoRequesitoColegio;
    }

    public Colegio getColegioDocumetoRequesitoColegio() {
        return colegioDocumetoRequesitoColegio;
    }

    public void setColegioDocumetoRequesitoColegio(Colegio colegioDocumetoRequesitoColegio) {
        this.colegioDocumetoRequesitoColegio = colegioDocumetoRequesitoColegio;
    }

    @Override
    public String toString() {
        return "DocumentoRequisitoColegio{" +
                "idDocumetoRequesitoColegio=" + idDocumetoRequesitoColegio +
                ", fecregisDocumetoRequesitoColegio=" + fecregisDocumetoRequesitoColegio +
                ", estadoDocumetoRequesitoColegio=" + estadoDocumetoRequesitoColegio +
                ", colegioDocumetoRequesitoColegio=" + colegioDocumetoRequesitoColegio +
                '}';
    }
}
