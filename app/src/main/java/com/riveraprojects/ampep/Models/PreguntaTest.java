package com.riveraprojects.ampep.Models;

import java.util.Date;

public class PreguntaTest {

    private int idPreguntaTest;
    private String descripcionPreguntaTest;
    private int estadoPreguntaTest;
    private Date fecregPreguntaTest;

    public int getIdPreguntaTest() {
        return idPreguntaTest;
    }

    public void setIdPreguntaTest(int idPreguntaTest) {
        this.idPreguntaTest = idPreguntaTest;
    }

    public String getDescripcionPreguntaTest() {
        return descripcionPreguntaTest;
    }

    public void setDescripcionPreguntaTest(String descripcionPreguntaTest) {
        this.descripcionPreguntaTest = descripcionPreguntaTest;
    }

    public int getEstadoPreguntaTest() {
        return estadoPreguntaTest;
    }

    public void setEstadoPreguntaTest(int estadoPreguntaTest) {
        this.estadoPreguntaTest = estadoPreguntaTest;
    }

    public Date getFecregPreguntaTest() {
        return fecregPreguntaTest;
    }

    public void setFecregPreguntaTest(Date fecregPreguntaTest) {
        this.fecregPreguntaTest = fecregPreguntaTest;
    }

    @Override
    public String toString() {
        return "PreguntaTest{" +
                "idPreguntaTest=" + idPreguntaTest +
                ", descripcionPreguntaTest='" + descripcionPreguntaTest + '\'' +
                ", estadoPreguntaTest=" + estadoPreguntaTest +
                ", fecregPreguntaTest=" + fecregPreguntaTest +
                '}';
    }
}
