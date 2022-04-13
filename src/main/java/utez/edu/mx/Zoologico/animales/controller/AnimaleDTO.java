package utez.edu.mx.Zoologico.animales.controller;

import utez.edu.mx.Zoologico.especie.model.Especie;
import utez.edu.mx.Zoologico.sex.modelo.Sex;
import utez.edu.mx.Zoologico.zoologico.model.Zoologico;

public class AnimaleDTO {
    private long id;
    private String claveAnimal;
    private String fechaNac;
    private Especie especie;
    private Zoologico zoologico;
    private Sex sex;

    public AnimaleDTO() {
    }

    public AnimaleDTO(long id, String claveAnimal, String fechaNac, Especie especie, Zoologico zoologico, Sex sex) {
        this.id = id;
        this.claveAnimal = claveAnimal;
        this.fechaNac = fechaNac;
        this.especie = especie;
        this.zoologico = zoologico;
        this.sex = sex;
    }

    public AnimaleDTO(String claveAnimal, String fechaNac, Especie especie, Zoologico zoologico, Sex sex) {
        this.claveAnimal = claveAnimal;
        this.fechaNac = fechaNac;
        this.especie = especie;
        this.zoologico = zoologico;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClaveAnimal() {
        return claveAnimal;
    }

    public void setClaveAnimal(String claveAnimal) {
        this.claveAnimal = claveAnimal;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Zoologico getZoologico() {
        return zoologico;
    }

    public void setZoologico(Zoologico zoologico) {
        this.zoologico = zoologico;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
