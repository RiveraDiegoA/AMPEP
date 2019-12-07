package com.riveraprojects.ampep.Models;

public class Distrito {

    private int idDistrito;
    private String descrDistrito;
    private Provincia ProvinciaDistrito;

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getDescrDistrito() {
        return descrDistrito;
    }

    public void setDescrDistrito(String descrDistrito) {
        this.descrDistrito = descrDistrito;
    }

    public Provincia getProvinciaDistrito() {
        return ProvinciaDistrito;
    }

    public void setProvinciaDistrito(Provincia provinciaDistrito) {
        ProvinciaDistrito = provinciaDistrito;
    }

    @Override
    public String toString() {
        return "Distrito{" +
                "idDistrito=" + idDistrito +
                ", descrDistrito='" + descrDistrito + '\'' +
                ", ProvinciaDistrito=" + ProvinciaDistrito +
                '}';
    }
}
