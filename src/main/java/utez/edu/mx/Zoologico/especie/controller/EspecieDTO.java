package utez.edu.mx.Zoologico.especie.controller;

import utez.edu.mx.Zoologico.pais.model.Pais;

public class EspecieDTO {
    private long id;
    private String nombreComun;
    private String nombreCientifico;
    private String familia;
    private String preligroExtincion;
    private Pais pais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getPreligroExtincion() {
        return preligroExtincion;
    }

    public void setPreligroExtincion(String preligroExtincion) {
        this.preligroExtincion = preligroExtincion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}

