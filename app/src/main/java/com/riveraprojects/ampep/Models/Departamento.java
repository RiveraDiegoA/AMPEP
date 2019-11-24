package com.riveraprojects.ampep.Models;

public class Departamento {
    private int idDepartamento;

    private String nomDepartamento;

    private Pais PaisDepartamento;

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomDepartamento() {
        return nomDepartamento;
    }

    public void setNomDepartamento(String nomDepartamento) {
        this.nomDepartamento = nomDepartamento;
    }

    public Pais getPaisDepartamento() {
        return PaisDepartamento;
    }

    public void setPaisDepartamento(Pais paisDepartamento) {
        PaisDepartamento = paisDepartamento;
    }
}
