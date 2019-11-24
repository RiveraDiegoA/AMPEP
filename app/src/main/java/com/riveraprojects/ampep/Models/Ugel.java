package com.riveraprojects.ampep.Models;

import java.util.Date;

public class Ugel {
    private int idUgel;

    private String idUnicUgel;

    private String descrUgel;

    private String estadoUgel;

    private Date fecRegUgel;

    public int getIdUgel() {
        return idUgel;
    }

    public void setIdUgel(int idUgel) {
        this.idUgel = idUgel;
    }

    public String getIdUnicUgel() {
        return idUnicUgel;
    }

    public void setIdUnicUgel(String idUnicUgel) {
        this.idUnicUgel = idUnicUgel;
    }

    public String getDescrUgel() {
        return descrUgel;
    }

    public void setDescrUgel(String descrUgel) {
        this.descrUgel = descrUgel;
    }

    public String getEstadoUgel() {
        return estadoUgel;
    }

    public void setEstadoUgel(String estadoUgel) {
        this.estadoUgel = estadoUgel;
    }

    public Date getFecRegUgel() {
        return fecRegUgel;
    }

    public void setFecRegUgel(Date fecRegUgel) {
        this.fecRegUgel = fecRegUgel;
    }
}
