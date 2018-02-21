package com.example.jorge.jorgegomezmoralesev2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jorge on 21/02/18.
 */

public class Pais implements Serializable {

    private String nombreIngles;
    private String nombreCastellano;
    private String poblacion;
    private String latitud;
    private String longitud;
    private String cod2Letras;
    private String cod3Letras;
    private String capital;
    private String continente;
    private ArrayList<String> paisesFronterizos;

    public Pais(){}

    public Pais(String nombreIngles, String nombreCastellano, String poblacion, String latitud, String longitud, String cod2Letras, String cod3Letras, String capital, String continente, ArrayList<String>  paisesFronterizos) {
        this.nombreIngles = nombreIngles;
        this.nombreCastellano = nombreCastellano;
        this.poblacion = poblacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.cod2Letras = cod2Letras;
        this.cod3Letras = cod3Letras;
        this.capital = capital;
        this.continente = continente;
        this.paisesFronterizos = paisesFronterizos;
    }

    public String getNombreIngles() {
        return nombreIngles;
    }

    public void setNombreIngles(String nombreIngles) {
        this.nombreIngles = nombreIngles;
    }

    public String getNombreCastellano() {
        return nombreCastellano;
    }

    public void setNombreCastellano(String nombreCastellano) {
        this.nombreCastellano = nombreCastellano;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getCod2Letras() {
        return cod2Letras;
    }

    public void setCod2Letras(String cod2Letras) {
        this.cod2Letras = cod2Letras;
    }

    public String getCod3Letras() {
        return cod3Letras;
    }

    public void setCod3Letras(String cod3Letras) {
        this.cod3Letras = cod3Letras;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public ArrayList<String> getPaisesFronterizos() {
        return paisesFronterizos;
    }

    public void setPaisesFronterizos(ArrayList<String> paisesFronterizos) {
        this.paisesFronterizos = paisesFronterizos;
    }
}
