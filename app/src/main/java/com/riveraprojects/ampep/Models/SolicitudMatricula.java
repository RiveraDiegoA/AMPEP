package com.riveraprojects.ampep.Models;

import java.util.Date;

public class SolicitudMatricula {

    private int idSolicitudMatricula;

    private Date fecSolicitudMatricula;

    private Date fecregisSolicitudMatricula;

    private Date fecnacpostulanteSolicitudMatricula;

    private String paisnacimientopostulanteSolicitud;

    private String departamentoactualpostulanteSolicitud;

    private String provinciaactualpostulanteSolicitud;

    private String distritoactualpostulanteSolicitud;

    private String alergiaspostulanteSolicitud;

    private String probvisualpostulanteSolicitud;

    private String probauditivpostulanteSolicitud;

    private String saludinfanciapostulanteSolicitud;

    private String infoadicionalpostulanteSolicitud;

    private Colegio colegioSolicitudMatricula;

    private Apoderado apoderadoSolicitudMatricula;

    private GradoEscolar gradoSolicitudMatricula;

    private Distrito distritoSolicitudMatricula;

    @Override
    public String toString() {
        return "SolicitudMatricula{" +
                "idSolicitudMatricula=" + idSolicitudMatricula +
                ", fecSolicitudMatricula=" + fecSolicitudMatricula +
                ", fecregisSolicitudMatricula=" + fecregisSolicitudMatricula +
                ", fecnacpostulanteSolicitudMatricula=" + fecnacpostulanteSolicitudMatricula +
                ", paisnacimientopostulanteSolicitud='" + paisnacimientopostulanteSolicitud + '\'' +
                ", departamentoactualpostulanteSolicitud='" + departamentoactualpostulanteSolicitud + '\'' +
                ", provinciaactualpostulanteSolicitud='" + provinciaactualpostulanteSolicitud + '\'' +
                ", distritoactualpostulanteSolicitud='" + distritoactualpostulanteSolicitud + '\'' +
                ", alergiaspostulanteSolicitud='" + alergiaspostulanteSolicitud + '\'' +
                ", probvisualpostulanteSolicitud='" + probvisualpostulanteSolicitud + '\'' +
                ", probauditivpostulanteSolicitud='" + probauditivpostulanteSolicitud + '\'' +
                ", saludinfanciapostulanteSolicitud='" + saludinfanciapostulanteSolicitud + '\'' +
                ", infoadicionalpostulanteSolicitud='" + infoadicionalpostulanteSolicitud + '\'' +
                ", colegioSolicitudMatricula=" + colegioSolicitudMatricula +
                ", apoderadoSolicitudMatricula=" + apoderadoSolicitudMatricula +
                ", gradoSolicitudMatricula=" + gradoSolicitudMatricula +
                ", distritoSolicitudMatricula=" + distritoSolicitudMatricula +
                '}';
    }
}
