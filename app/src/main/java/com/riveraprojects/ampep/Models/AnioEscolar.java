package com.riveraprojects.ampep.Models;

import java.util.Date;

public class AnioEscolar {
    private int idAnioEscolar;

    private Date fecregisAnioEscolar;

    private String descripAnioEscolar;

    private String estadoAnioEscolar;

    private Date fecicioAnioEscolar;

    private Date fecfinAnioEscolar;

    private Colegio colegioAnioEscolar;

    public int getIdAnioEscolar() {
        return idAnioEscolar;
    }

    public void setIdAnioEscolar(int idAnioEscolar) {
        this.idAnioEscolar = idAnioEscolar;
    }

    public Date getFecregisAnioEscolar() {
        return fecregisAnioEscolar;
    }

    public void setFecregisAnioEscolar(Date fecregisAnioEscolar) {
        this.fecregisAnioEscolar = fecregisAnioEscolar;
    }

    public String getDescripAnioEscolar() {
        return descripAnioEscolar;
    }

    public void setDescripAnioEscolar(String descripAnioEscolar) {
        this.descripAnioEscolar = descripAnioEscolar;
    }

    public String getEstadoAnioEscolar() {
        return estadoAnioEscolar;
    }

    public void setEstadoAnioEscolar(String estadoAnioEscolar) {
        this.estadoAnioEscolar = estadoAnioEscolar;
    }

    public Date getFecicioAnioEscolar() {
        return fecicioAnioEscolar;
    }

    public void setFecicioAnioEscolar(Date fecicioAnioEscolar) {
        this.fecicioAnioEscolar = fecicioAnioEscolar;
    }

    public Date getFecfinAnioEscolar() {
        return fecfinAnioEscolar;
    }

    public void setFecfinAnioEscolar(Date fecfinAnioEscolar) {
        this.fecfinAnioEscolar = fecfinAnioEscolar;
    }

    public Colegio getColegioAnioEscolar() {
        return colegioAnioEscolar;
    }

    public void setColegioAnioEscolar(Colegio colegioAnioEscolar) {
        this.colegioAnioEscolar = colegioAnioEscolar;
    }
}
