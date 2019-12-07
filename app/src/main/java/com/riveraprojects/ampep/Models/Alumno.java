package com.riveraprojects.ampep.Models;

import java.util.Date;

public class Alumno {

    private int idAlumno;

    private String dniAlumno;

    private String apepatAlumno;

    private String apematAlumno;

    private String nomAlumno;

    private String lugarnacAlumno;

    private Date fecnacimientoApoderado;

    private String direcactualAlumno;

    private String fotoAlumno;

    private String descripAlumno;

    private String infoimportanteAlumno;

    private Date fecregistroAlumno;

    private Colegio colegioAlumno;

    private Distrito distritoAlumno;

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public String getApepatAlumno() {
        return apepatAlumno;
    }

    public void setApepatAlumno(String apepatAlumno) {
        this.apepatAlumno = apepatAlumno;
    }

    public String getApematAlumno() {
        return apematAlumno;
    }

    public void setApematAlumno(String apematAlumno) {
        this.apematAlumno = apematAlumno;
    }

    public String getNomAlumno() {
        return nomAlumno;
    }

    public void setNomAlumno(String nomAlumno) {
        this.nomAlumno = nomAlumno;
    }

    public String getLugarnacAlumno() {
        return lugarnacAlumno;
    }

    public void setLugarnacAlumno(String lugarnacAlumno) {
        this.lugarnacAlumno = lugarnacAlumno;
    }

    public Date getFecnacimientoApoderado() {
        return fecnacimientoApoderado;
    }

    public void setFecnacimientoApoderado(Date fecnacimientoApoderado) {
        this.fecnacimientoApoderado = fecnacimientoApoderado;
    }

    public String getDirecactualAlumno() {
        return direcactualAlumno;
    }

    public void setDirecactualAlumno(String direcactualAlumno) {
        this.direcactualAlumno = direcactualAlumno;
    }

    public String getFotoAlumno() {
        return fotoAlumno;
    }

    public void setFotoAlumno(String fotoAlumno) {
        this.fotoAlumno = fotoAlumno;
    }

    public String getDescripAlumno() {
        return descripAlumno;
    }

    public void setDescripAlumno(String descripAlumno) {
        this.descripAlumno = descripAlumno;
    }

    public String getInfoimportanteAlumno() {
        return infoimportanteAlumno;
    }

    public void setInfoimportanteAlumno(String infoimportanteAlumno) {
        this.infoimportanteAlumno = infoimportanteAlumno;
    }

    public Date getFecregistroAlumno() {
        return fecregistroAlumno;
    }

    public void setFecregistroAlumno(Date fecregistroAlumno) {
        this.fecregistroAlumno = fecregistroAlumno;
    }

    public Colegio getColegioAlumno() {
        return colegioAlumno;
    }

    public void setColegioAlumno(Colegio colegioAlumno) {
        this.colegioAlumno = colegioAlumno;
    }

    public Distrito getDistritoAlumno() {
        return distritoAlumno;
    }

    public void setDistritoAlumno(Distrito distritoAlumno) {
        this.distritoAlumno = distritoAlumno;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", dniAlumno='" + dniAlumno + '\'' +
                ", apepatAlumno='" + apepatAlumno + '\'' +
                ", apematAlumno='" + apematAlumno + '\'' +
                ", nomAlumno='" + nomAlumno + '\'' +
                ", lugarnacAlumno='" + lugarnacAlumno + '\'' +
                ", fecnacimientoApoderado=" + fecnacimientoApoderado +
                ", direcactualAlumno='" + direcactualAlumno + '\'' +
                ", fotoAlumno='" + fotoAlumno + '\'' +
                ", descripAlumno='" + descripAlumno + '\'' +
                ", infoimportanteAlumno='" + infoimportanteAlumno + '\'' +
                ", fecregistroAlumno=" + fecregistroAlumno +
                ", colegioAlumno=" + colegioAlumno +
                ", distritoAlumno=" + distritoAlumno +
                '}';
    }
}
