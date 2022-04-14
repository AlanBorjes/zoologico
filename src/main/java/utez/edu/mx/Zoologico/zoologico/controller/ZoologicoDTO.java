package utez.edu.mx.Zoologico.zoologico.controller;

import utez.edu.mx.Zoologico.cuidad.model.Ciudad;

public class ZoologicoDTO {
    private long id;
    private String name;

    private String tamano;
    private String presupuesto;
    private Ciudad ciudadId;

    public ZoologicoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Ciudad getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Ciudad ciudadId) {
        this.ciudadId = ciudadId;
    }
}
