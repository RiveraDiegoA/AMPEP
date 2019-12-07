package com.riveraprojects.ampep.Models;

import java.util.Date;

public class Anuncio {

    private int idAnuncio;
    private String titAnuncio;
    private String descAnuncio;
    private Date fecRegAnuncio;
    private Date fecinAnuncio;
    private Date fecfinAnuncio;
    private String estadoAnuncio;
    private Colegio colegioAnuncio;
    private GradoEscolar gradoAnuncio;
    private UsuarioSistema usuariosisAnuncio;

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getTitAnuncio() {
        return titAnuncio;
    }

    public void setTitAnuncio(String titAnuncio) {
        this.titAnuncio = titAnuncio;
    }

    public String getDescAnuncio() {
        return descAnuncio;
    }

    public void setDescAnuncio(String descAnuncio) {
        this.descAnuncio = descAnuncio;
    }

    public Date getFecRegAnuncio() {
        return fecRegAnuncio;
    }

    public void setFecRegAnuncio(Date fecRegAnuncio) {
        this.fecRegAnuncio = fecRegAnuncio;
    }

    public Date getFecinAnuncio() {
        return fecinAnuncio;
    }

    public void setFecinAnuncio(Date fecinAnuncio) {
        this.fecinAnuncio = fecinAnuncio;
    }

    public Date getFecfinAnuncio() {
        return fecfinAnuncio;
    }

    public void setFecfinAnuncio(Date fecfinAnuncio) {
        this.fecfinAnuncio = fecfinAnuncio;
    }

    public String getEstadoAnuncio() {
        return estadoAnuncio;
    }

    public void setEstadoAnuncio(String estadoAnuncio) {
        this.estadoAnuncio = estadoAnuncio;
    }

    public Colegio getColegioAnuncio() {
        return colegioAnuncio;
    }

    public void setColegioAnuncio(Colegio colegioAnuncio) {
        this.colegioAnuncio = colegioAnuncio;
    }

    public GradoEscolar getGradoAnuncio() {
        return gradoAnuncio;
    }

    public void setGradoAnuncio(GradoEscolar gradoAnuncio) {
        this.gradoAnuncio = gradoAnuncio;
    }

    public UsuarioSistema getUsuariosisAnuncio() {
        return usuariosisAnuncio;
    }

    public void setUsuariosisAnuncio(UsuarioSistema usuariosisAnuncio) {
        this.usuariosisAnuncio = usuariosisAnuncio;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "idAnuncio=" + idAnuncio +
                ", titAnuncio='" + titAnuncio + '\'' +
                ", descAnuncio='" + descAnuncio + '\'' +
                ", fecRegAnuncio=" + fecRegAnuncio +
                ", fecinAnuncio=" + fecinAnuncio +
                ", fecfinAnuncio=" + fecfinAnuncio +
                ", estadoAnuncio='" + estadoAnuncio + '\'' +
                ", colegioAnuncio=" + colegioAnuncio +
                ", gradoAnuncio=" + gradoAnuncio +
                ", usuariosisAnuncio=" + usuariosisAnuncio +
                '}';
    }
}
