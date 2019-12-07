package com.riveraprojects.ampep.Models;

import java.util.Date;

public class Profesor {

    private int idProfeso;
    private String apePatern;
    private String apeMatern;
    private String nombres;
    private Date fechNacim;
    private String estado;
    private String domicilio;
    private String telefono;
    private String celular;
    private String correo;
    private String gradInstr;
    private String direTraba;
    private String estaCivil;
    private String fotografi;
    private String nroRegpro;
    private String nroDniProfesor;
    private Colegio idColegioProf;
    private Distrito idDistritProf;

    public int getIdProfeso() {
        return idProfeso;
    }

    public void setIdProfeso(int idProfeso) {
        this.idProfeso = idProfeso;
    }

    public String getApePatern() {
        return apePatern;
    }

    public void setApePatern(String apePatern) {
        this.apePatern = apePatern;
    }

    public String getApeMatern() {
        return apeMatern;
    }

    public void setApeMatern(String apeMatern) {
        this.apeMatern = apeMatern;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechNacim() {
        return fechNacim;
    }

    public void setFechNacim(Date fechNacim) {
        this.fechNacim = fechNacim;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGradInstr() {
        return gradInstr;
    }

    public void setGradInstr(String gradInstr) {
        this.gradInstr = gradInstr;
    }

    public String getDireTraba() {
        return direTraba;
    }

    public void setDireTraba(String direTraba) {
        this.direTraba = direTraba;
    }

    public String getEstaCivil() {
        return estaCivil;
    }

    public void setEstaCivil(String estaCivil) {
        this.estaCivil = estaCivil;
    }

    public String getFotografi() {
        return fotografi;
    }

    public void setFotografi(String fotografi) {
        this.fotografi = fotografi;
    }

    public String getNroRegpro() {
        return nroRegpro;
    }

    public void setNroRegpro(String nroRegpro) {
        this.nroRegpro = nroRegpro;
    }

    public String getNroDniProfesor() {
        return nroDniProfesor;
    }

    public void setNroDniProfesor(String nroDniProfesor) {
        this.nroDniProfesor = nroDniProfesor;
    }

    public Colegio getIdColegioProf() {
        return idColegioProf;
    }

    public void setIdColegioProf(Colegio idColegioProf) {
        this.idColegioProf = idColegioProf;
    }

    public Distrito getIdDistritProf() {
        return idDistritProf;
    }

    public void setIdDistritProf(Distrito idDistritProf) {
        this.idDistritProf = idDistritProf;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "idProfeso=" + idProfeso +
                ", apePatern='" + apePatern + '\'' +
                ", apeMatern='" + apeMatern + '\'' +
                ", nombres='" + nombres + '\'' +
                ", fechNacim=" + fechNacim +
                ", estado='" + estado + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", telefono='" + telefono + '\'' +
                ", celular='" + celular + '\'' +
                ", correo='" + correo + '\'' +
                ", gradInstr='" + gradInstr + '\'' +
                ", direTraba='" + direTraba + '\'' +
                ", estaCivil='" + estaCivil + '\'' +
                ", fotografi='" + fotografi + '\'' +
                ", nroRegpro='" + nroRegpro + '\'' +
                ", nroDniProfesor='" + nroDniProfesor + '\'' +
                ", idColegioProf=" + idColegioProf +
                ", idDistritProf=" + idDistritProf +
                '}';
    }
}
