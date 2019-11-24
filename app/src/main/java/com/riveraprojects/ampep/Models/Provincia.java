package com.riveraprojects.ampep.Models;

public class Provincia {
    private int idProvincia;

    private String nomProvincia;

    private Departamento DepartamentoProvincia;

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNomProvincia() {
        return nomProvincia;
    }

    public void setNomProvincia(String nomProvincia) {
        this.nomProvincia = nomProvincia;
    }

    public Departamento getDepartamentoProvincia() {
        return DepartamentoProvincia;
    }

    public void setDepartamentoProvincia(Departamento departamentoProvincia) {
        DepartamentoProvincia = departamentoProvincia;
    }
}
