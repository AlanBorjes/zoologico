package utez.edu.mx.Zoologico.animales.model;

import org.springframework.lang.NonNull;
import utez.edu.mx.Zoologico.especie.model.Especie;
import utez.edu.mx.Zoologico.sex.modelo.Sex;
import utez.edu.mx.Zoologico.zoologico.model.Zoologico;

import javax.persistence.*;

@Entity
public class Animales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String claveAnimal;
    private String fechaNac;
    @ManyToOne
    @JoinColumn(name = "especie_id", nullable = false)
    @NonNull
    private Especie especie;
    @ManyToOne
    @JoinColumn(name = "zoologico_id", nullable = false)
    @NonNull
    private Zoologico zoologico;
    @ManyToOne
    @JoinColumn(name = "sex_id", nullable = false)
    @NonNull
    private Sex sex;

    public Animales() {
    }

    public Animales(long id, String claveAnimal, String fechaNac, @NonNull Especie especie, @NonNull Zoologico zoologico, @NonNull Sex sex) {
        this.id = id;
        this.claveAnimal = claveAnimal;
        this.fechaNac = fechaNac;
        this.especie = especie;
        this.zoologico = zoologico;
        this.sex = sex;
    }

    public Animales(String claveAnimal, String fechaNac, @NonNull Especie especie, @NonNull Zoologico zoologico, @NonNull Sex sex) {
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

    @NonNull
    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(@NonNull Especie especie) {
        this.especie = especie;
    }

    @NonNull
    public Zoologico getZoologico() {
        return zoologico;
    }

    public void setZoologico(@NonNull Zoologico zoologico) {
        this.zoologico = zoologico;
    }

    @NonNull
    public Sex getSex() {
        return sex;
    }

    public void setSex(@NonNull Sex sex) {
        this.sex = sex;
    }
}
