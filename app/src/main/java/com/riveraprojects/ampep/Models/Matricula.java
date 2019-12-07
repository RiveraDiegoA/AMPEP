package com.riveraprojects.ampep.Models;

import java.util.Date;

public class Matricula {

    private int idMatricula;
    private String estadoMatricula;
    private Date fecregistroMatricula;
    private Colegio colegioMatricula;
    private Apoderado apoderadoMatricula;
    private Alumno alumnoMatricula;
    private SeccionEscolar seccionescolarMatricula;
    private AnioEscolar anioescolarMatricula;

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getEstadoMatricula() {
        return estadoMatricula;
    }

    public void setEstadoMatricula(String estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

    public Date getFecregistroMatricula() {
        return fecregistroMatricula;
    }

    public void setFecregistroMatricula(Date fecregistroMatricula) {
        this.fecregistroMatricula = fecregistroMatricula;
    }

    public Colegio getColegioMatricula() {
        return colegioMatricula;
    }

    public void setColegioMatricula(Colegio colegioMatricula) {
        this.colegioMatricula = colegioMatricula;
    }

    public Apoderado getApoderadoMatricula() {
        return apoderadoMatricula;
    }

    public void setApoderadoMatricula(Apoderado apoderadoMatricula) {
        this.apoderadoMatricula = apoderadoMatricula;
    }

    public Alumno getAlumnoMatricula() {
        return alumnoMatricula;
    }

    public void setAlumnoMatricula(Alumno alumnoMatricula) {
        this.alumnoMatricula = alumnoMatricula;
    }

    public SeccionEscolar getSeccionescolarMatricula() {
        return seccionescolarMatricula;
    }

    public void setSeccionescolarMatricula(SeccionEscolar seccionescolarMatricula) {
        this.seccionescolarMatricula = seccionescolarMatricula;
    }

    public AnioEscolar getAnioescolarMatricula() {
        return anioescolarMatricula;
    }

    public void setAnioescolarMatricula(AnioEscolar anioescolarMatricula) {
        this.anioescolarMatricula = anioescolarMatricula;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "idMatricula=" + idMatricula +
                ", estadoMatricula='" + estadoMatricula + '\'' +
                ", fecregistroMatricula=" + fecregistroMatricula +
                ", colegioMatricula=" + colegioMatricula +
                ", apoderadoMatricula=" + apoderadoMatricula +
                ", alumnoMatricula=" + alumnoMatricula +
                ", seccionescolarMatricula=" + seccionescolarMatricula +
                ", anioescolarMatricula=" + anioescolarMatricula +
                '}';
    }
}
