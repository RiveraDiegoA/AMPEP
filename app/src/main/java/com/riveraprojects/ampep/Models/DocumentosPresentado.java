package com.riveraprojects.ampep.Models;

import java.util.Date;

public class DocumentosPresentado {

    private int idDocumentosPresentado;
    private String detalleDocumentosPresentado;
    private Date fecregDocumentosPresentado;
    private int estadoDocumentosPresentado;
    private Colegio colegioDocumentosPresentado;
    private SolicitudMatricula solicitudmatDocumentosPresentado;
    private Apoderado apoderadoDocumentosPresentado;

    public int getIdDocumentosPresentado() {
        return idDocumentosPresentado;
    }

    public void setIdDocumentosPresentado(int idDocumentosPresentado) {
        this.idDocumentosPresentado = idDocumentosPresentado;
    }

    public String getDetalleDocumentosPresentado() {
        return detalleDocumentosPresentado;
    }

    public void setDetalleDocumentosPresentado(String detalleDocumentosPresentado) {
        this.detalleDocumentosPresentado = detalleDocumentosPresentado;
    }

    public Date getFecregDocumentosPresentado() {
        return fecregDocumentosPresentado;
    }

    public void setFecregDocumentosPresentado(Date fecregDocumentosPresentado) {
        this.fecregDocumentosPresentado = fecregDocumentosPresentado;
    }

    public int getEstadoDocumentosPresentado() {
        return estadoDocumentosPresentado;
    }

    public void setEstadoDocumentosPresentado(int estadoDocumentosPresentado) {
        this.estadoDocumentosPresentado = estadoDocumentosPresentado;
    }

    public Colegio getColegioDocumentosPresentado() {
        return colegioDocumentosPresentado;
    }

    public void setColegioDocumentosPresentado(Colegio colegioDocumentosPresentado) {
        this.colegioDocumentosPresentado = colegioDocumentosPresentado;
    }

    public SolicitudMatricula getSolicitudmatDocumentosPresentado() {
        return solicitudmatDocumentosPresentado;
    }

    public void setSolicitudmatDocumentosPresentado(SolicitudMatricula solicitudmatDocumentosPresentado) {
        this.solicitudmatDocumentosPresentado = solicitudmatDocumentosPresentado;
    }

    public Apoderado getApoderadoDocumentosPresentado() {
        return apoderadoDocumentosPresentado;
    }

    public void setApoderadoDocumentosPresentado(Apoderado apoderadoDocumentosPresentado) {
        this.apoderadoDocumentosPresentado = apoderadoDocumentosPresentado;
    }

    @Override
    public String toString() {
        return "DocumentosPresentado{" +
                "idDocumentosPresentado=" + idDocumentosPresentado +
                ", detalleDocumentosPresentado='" + detalleDocumentosPresentado + '\'' +
                ", fecregDocumentosPresentado=" + fecregDocumentosPresentado +
                ", estadoDocumentosPresentado=" + estadoDocumentosPresentado +
                ", colegioDocumentosPresentado=" + colegioDocumentosPresentado +
                ", solicitudmatDocumentosPresentado=" + solicitudmatDocumentosPresentado +
                ", apoderadoDocumentosPresentado=" + apoderadoDocumentosPresentado +
                '}';
    }
}
