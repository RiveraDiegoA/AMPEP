package com.riveraprojects.ampep.Models;

import java.util.Date;

public class TipoUsuario {
    private int idTipousu;

    private Date fechCreac;

    private String descripci;

    private String estado;

    public int getIdTipousu() {
        return idTipousu;
    }

    public void setIdTipousu(int idTipousu) {
        this.idTipousu = idTipousu;
    }

    public Date getFechCreac() {
        return fechCreac;
    }

    public void setFechCreac(Date fechCreac) {
        this.fechCreac = fechCreac;
    }

    public String getDescripci() {
        return descripci;
    }

    public void setDescripci(String descripci) {
        this.descripci = descripci;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
