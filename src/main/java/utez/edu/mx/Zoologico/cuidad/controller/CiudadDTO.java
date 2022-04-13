package utez.edu.mx.Zoologico.cuidad.controller;

import utez.edu.mx.Zoologico.estado.model.Estado;

public class CiudadDTO {
    private long id;
    private String description;
    private Estado estado;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
