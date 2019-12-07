package com.riveraprojects.ampep.Models;

import java.util.Date;

public class DocumentoRequerido {

    private int idDocumentoRequerido;
    private String descripcionDocRequerido;
    private String formatoDocRequerido;
    private Date fecregistroDocRequerido;
    private int estadoDocRequerido;

    public int getIdDocumentoRequerido() {
        return idDocumentoRequerido;
    }

    public void setIdDocumentoRequerido(int idDocumentoRequerido) {
        this.idDocumentoRequerido = idDocumentoRequerido;
    }

    public String getDescripcionDocRequerido() {
        return descripcionDocRequerido;
    }

    public void setDescripcionDocRequerido(String descripcionDocRequerido) {
        this.descripcionDocRequerido = descripcionDocRequerido;
    }

    public String getFormatoDocRequerido() {
        return formatoDocRequerido;
    }

    public void setFormatoDocRequerido(String formatoDocRequerido) {
        this.formatoDocRequerido = formatoDocRequerido;
    }

    public Date getFecregistroDocRequerido() {
        return fecregistroDocRequerido;
    }

    public void setFecregistroDocRequerido(Date fecregistroDocRequerido) {
        this.fecregistroDocRequerido = fecregistroDocRequerido;
    }

    public int getEstadoDocRequerido() {
        return estadoDocRequerido;
    }

    public void setEstadoDocRequerido(int estadoDocRequerido) {
        this.estadoDocRequerido = estadoDocRequerido;
    }

    @Override
    public String toString() {
        return "DocumentoRequerido{" +
                "idDocumentoRequerido=" + idDocumentoRequerido +
                ", descripcionDocRequerido='" + descripcionDocRequerido + '\'' +
                ", formatoDocRequerido='" + formatoDocRequerido + '\'' +
                ", fecregistroDocRequerido=" + fecregistroDocRequerido +
                ", estadoDocRequerido=" + estadoDocRequerido +
                '}';
    }
}
