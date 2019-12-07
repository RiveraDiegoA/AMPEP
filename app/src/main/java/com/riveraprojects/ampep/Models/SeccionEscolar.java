package com.riveraprojects.ampep.Models;

import java.util.Date;

public class SeccionEscolar {

    private int idSeccion;
    private Date fecregistroSeccion;
    private String descripcionSeccion;
    private Profesor profesorSeccion;
    private Colegio colegioSeccion;
    private GradoEscolar gradoescolarSeccion;

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Date getFecregistroSeccion() {
        return fecregistroSeccion;
    }

    public void setFecregistroSeccion(Date fecregistroSeccion) {
        this.fecregistroSeccion = fecregistroSeccion;
    }

    public String getDescripcionSeccion() {
        return descripcionSeccion;
    }

    public void setDescripcionSeccion(String descripcionSeccion) {
        this.descripcionSeccion = descripcionSeccion;
    }

    public Profesor getProfesorSeccion() {
        return profesorSeccion;
    }

    public void setProfesorSeccion(Profesor profesorSeccion) {
        this.profesorSeccion = profesorSeccion;
    }

    public Colegio getColegioSeccion() {
        return colegioSeccion;
    }

    public void setColegioSeccion(Colegio colegioSeccion) {
        this.colegioSeccion = colegioSeccion;
    }

    public GradoEscolar getGradoescolarSeccion() {
        return gradoescolarSeccion;
    }

    public void setGradoescolarSeccion(GradoEscolar gradoescolarSeccion) {
        this.gradoescolarSeccion = gradoescolarSeccion;
    }

    @Override
    public String toString() {
        return "SeccionEscolar{" +
                "idSeccion=" + idSeccion +
                ", fecregistroSeccion=" + fecregistroSeccion +
                ", descripcionSeccion='" + descripcionSeccion + '\'' +
                ", profesorSeccion=" + profesorSeccion +
                ", colegioSeccion=" + colegioSeccion +
                ", gradoescolarSeccion=" + gradoescolarSeccion +
                '}';
    }
}
