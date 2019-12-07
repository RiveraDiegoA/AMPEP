package com.riveraprojects.ampep.Models;

import java.util.Date;

public class GradoEscolar {

    private int idGrado;
    private Date fecregistroApoderado;
    private String estadoApoderado;
    private String nivelGradoEscolar;
    private String descripcionGradoEscolar;
    private AnioEscolar anioEscolarGrado;
    private Colegio colegioGradoEscolar;

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public Date getFecregistroApoderado() {
        return fecregistroApoderado;
    }

    public void setFecregistroApoderado(Date fecregistroApoderado) {
        this.fecregistroApoderado = fecregistroApoderado;
    }

    public String getEstadoApoderado() {
        return estadoApoderado;
    }

    public void setEstadoApoderado(String estadoApoderado) {
        this.estadoApoderado = estadoApoderado;
    }

    public String getNivelGradoEscolar() {
        return nivelGradoEscolar;
    }

    public void setNivelGradoEscolar(String nivelGradoEscolar) {
        this.nivelGradoEscolar = nivelGradoEscolar;
    }

    public String getDescripcionGradoEscolar() {
        return descripcionGradoEscolar;
    }

    public void setDescripcionGradoEscolar(String descripcionGradoEscolar) {
        this.descripcionGradoEscolar = descripcionGradoEscolar;
    }

    public AnioEscolar getAnioEscolarGrado() {
        return anioEscolarGrado;
    }

    public void setAnioEscolarGrado(AnioEscolar anioEscolarGrado) {
        this.anioEscolarGrado = anioEscolarGrado;
    }

    public Colegio getColegioGradoEscolar() {
        return colegioGradoEscolar;
    }

    public void setColegioGradoEscolar(Colegio colegioGradoEscolar) {
        this.colegioGradoEscolar = colegioGradoEscolar;
    }

    @Override
    public String toString() {
        return "GradoEscolar{" +
                "idGrado=" + idGrado +
                ", fecregistroApoderado=" + fecregistroApoderado +
                ", estadoApoderado='" + estadoApoderado + '\'' +
                ", nivelGradoEscolar='" + nivelGradoEscolar + '\'' +
                ", descripcionGradoEscolar='" + descripcionGradoEscolar + '\'' +
                ", anioEscolarGrado=" + anioEscolarGrado +
                ", colegioGradoEscolar=" + colegioGradoEscolar +
                '}';
    }
}
