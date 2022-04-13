package utez.edu.mx.Zoologico.estado.controller;

import utez.edu.mx.Zoologico.pais.model.Pais;

public class EstadoDTO {
    private long id;
    private String description;
    private Pais pais;

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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
