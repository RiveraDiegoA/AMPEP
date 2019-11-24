package com.riveraprojects.ampep.Models;

import java.util.Date;

public class Anuncio {

    private String titulo;

    private String descrip;

    private String estado;

    private Date fechRegis;

    private Date horIniacc;

    private Date fecFinacc;

    private Colegio colegioAnuncio;

    private GradoEscolar gradoColegioAnuncio;

    private UsuarioSistema usuarioAnuncio;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechRegis() {
        return fechRegis;
    }

    public void setFechRegis(Date fechRegis) {
        this.fechRegis = fechRegis;
    }

    public Date getHorIniacc() {
        return horIniacc;
    }

    public void setHorIniacc(Date horIniacc) {
        this.horIniacc = horIniacc;
    }

    public Date getFecFinacc() {
        return fecFinacc;
    }

    public void setFecFinacc(Date fecFinacc) {
        this.fecFinacc = fecFinacc;
    }

    public Colegio getColegioAnuncio() {
        return colegioAnuncio;
    }

    public void setColegioAnuncio(Colegio colegioAnuncio) {
        this.colegioAnuncio = colegioAnuncio;
    }

    public GradoEscolar getGradoColegioAnuncio() {
        return gradoColegioAnuncio;
    }

    public void setGradoColegioAnuncio(GradoEscolar gradoColegioAnuncio) {
        this.gradoColegioAnuncio = gradoColegioAnuncio;
    }

    public UsuarioSistema getUsuarioAnuncio() {
        return usuarioAnuncio;
    }

    public void setUsuarioAnuncio(UsuarioSistema usuarioAnuncio) {
        this.usuarioAnuncio = usuarioAnuncio;
    }
}
