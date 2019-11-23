package com.riveraprojects.ampep.Models;

import java.util.Date;

public class UsuarioSistema {

    private int idUsusist;

    private Date fechCreac;

    private String usuario;

    private Date fecIniciacc;

    private Date horIniciacc;

    private Date fecFinacc;

    private Date horFinacc;

    private String contrasen;

    private String estado;

    private int idPersona;

    private TipoUsuario idTipoUsuSist;

    public int getIdUsusist() {
        return idUsusist;
    }

    public void setIdUsusist(int idUsusist) {
        this.idUsusist = idUsusist;
    }

    public Date getFechCreac() {
        return fechCreac;
    }

    public void setFechCreac(Date fechCreac) {
        this.fechCreac = fechCreac;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecIniciacc() {
        return fecIniciacc;
    }

    public void setFecIniciacc(Date fecIniciacc) {
        this.fecIniciacc = fecIniciacc;
    }

    public Date getHorIniciacc() {
        return horIniciacc;
    }

    public void setHorIniciacc(Date horIniciacc) {
        this.horIniciacc = horIniciacc;
    }

    public Date getFecFinacc() {
        return fecFinacc;
    }

    public void setFecFinacc(Date fecFinacc) {
        this.fecFinacc = fecFinacc;
    }

    public Date getHorFinacc() {
        return horFinacc;
    }

    public void setHorFinacc(Date horFinacc) {
        this.horFinacc = horFinacc;
    }

    public String getContrasen() {
        return contrasen;
    }

    public void setContrasen(String contrasen) {
        this.contrasen = contrasen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public TipoUsuario getIdTipoUsuSist() {
        return idTipoUsuSist;
    }

    public void setIdTipoUsuSist(TipoUsuario idTipoUsuSist) {
        this.idTipoUsuSist = idTipoUsuSist;
    }
}
