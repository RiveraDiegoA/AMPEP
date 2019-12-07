package com.riveraprojects.ampep.Models;

import java.util.Date;

public class Representante {

    private int idRepresentante;
    private String dniRepresentante;
    private String apepatRepresentante;
    private String apetRepresentante;
    private String nombreRepresentante;
    private String rucRepresentante;
    private String nitRepresentante;
    private String domicilioRepresentante;
    private String telefRepresentante;
    private String celuRepresentante;
    private String correoRepresentante;
    private String sexoRepresentante;
    private Date fecnacRepresentante;
    private Date fecregRepresentante;
    private Colegio colegioRepresentante;
    private Distrito distritoRepresentante;

    public int getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(int idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public String getDniRepresentante() {
        return dniRepresentante;
    }

    public void setDniRepresentante(String dniRepresentante) {
        this.dniRepresentante = dniRepresentante;
    }

    public String getApepatRepresentante() {
        return apepatRepresentante;
    }

    public void setApepatRepresentante(String apepatRepresentante) {
        this.apepatRepresentante = apepatRepresentante;
    }

    public String getApetRepresentante() {
        return apetRepresentante;
    }

    public void setApetRepresentante(String apetRepresentante) {
        this.apetRepresentante = apetRepresentante;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public String getRucRepresentante() {
        return rucRepresentante;
    }

    public void setRucRepresentante(String rucRepresentante) {
        this.rucRepresentante = rucRepresentante;
    }

    public String getNitRepresentante() {
        return nitRepresentante;
    }

    public void setNitRepresentante(String nitRepresentante) {
        this.nitRepresentante = nitRepresentante;
    }

    public String getDomicilioRepresentante() {
        return domicilioRepresentante;
    }

    public void setDomicilioRepresentante(String domicilioRepresentante) {
        this.domicilioRepresentante = domicilioRepresentante;
    }

    public String getTelefRepresentante() {
        return telefRepresentante;
    }

    public void setTelefRepresentante(String telefRepresentante) {
        this.telefRepresentante = telefRepresentante;
    }

    public String getCeluRepresentante() {
        return celuRepresentante;
    }

    public void setCeluRepresentante(String celuRepresentante) {
        this.celuRepresentante = celuRepresentante;
    }

    public String getCorreoRepresentante() {
        return correoRepresentante;
    }

    public void setCorreoRepresentante(String correoRepresentante) {
        this.correoRepresentante = correoRepresentante;
    }

    public String getSexoRepresentante() {
        return sexoRepresentante;
    }

    public void setSexoRepresentante(String sexoRepresentante) {
        this.sexoRepresentante = sexoRepresentante;
    }

    public Date getFecnacRepresentante() {
        return fecnacRepresentante;
    }

    public void setFecnacRepresentante(Date fecnacRepresentante) {
        this.fecnacRepresentante = fecnacRepresentante;
    }

    public Date getFecregRepresentante() {
        return fecregRepresentante;
    }

    public void setFecregRepresentante(Date fecregRepresentante) {
        this.fecregRepresentante = fecregRepresentante;
    }

    public Colegio getColegioRepresentante() {
        return colegioRepresentante;
    }

    public void setColegioRepresentante(Colegio colegioRepresentante) {
        this.colegioRepresentante = colegioRepresentante;
    }

    public Distrito getDistritoRepresentante() {
        return distritoRepresentante;
    }

    public void setDistritoRepresentante(Distrito distritoRepresentante) {
        this.distritoRepresentante = distritoRepresentante;
    }

    @Override
    public String toString() {
        return "Representante{" +
                "idRepresentante=" + idRepresentante +
                ", dniRepresentante='" + dniRepresentante + '\'' +
                ", apepatRepresentante='" + apepatRepresentante + '\'' +
                ", apetRepresentante='" + apetRepresentante + '\'' +
                ", nombreRepresentante='" + nombreRepresentante + '\'' +
                ", rucRepresentante='" + rucRepresentante + '\'' +
                ", nitRepresentante='" + nitRepresentante + '\'' +
                ", domicilioRepresentante='" + domicilioRepresentante + '\'' +
                ", telefRepresentante='" + telefRepresentante + '\'' +
                ", celuRepresentante='" + celuRepresentante + '\'' +
                ", correoRepresentante='" + correoRepresentante + '\'' +
                ", sexoRepresentante='" + sexoRepresentante + '\'' +
                ", fecnacRepresentante=" + fecnacRepresentante +
                ", fecregRepresentante=" + fecregRepresentante +
                ", colegioRepresentante=" + colegioRepresentante +
                ", distritoRepresentante=" + distritoRepresentante +
                '}';
    }
}
