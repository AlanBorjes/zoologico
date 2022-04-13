package utez.edu.mx.Zoologico.pais.controller;

import utez.edu.mx.Zoologico.continent.model.Continent;

public class PaisDTO {
    private long id;
    private String description;
    private Continent continent;

    public PaisDTO() {
    }

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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
