package utez.edu.mx.Zoologico.sex.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import utez.edu.mx.Zoologico.animales.model.Animales;
import utez.edu.mx.Zoologico.especie.model.Especie;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @OneToMany(mappedBy = "sex")
    @JsonIgnore
    private List<Animales> animalesList;


    public Sex() {
    }

    public Sex(String description) {
        this.description = description;
    }

    public Sex(long id, String description) {
        this.id = id;
        this.description = description;
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

    public List<Animales> getAnimalesList() {
        return animalesList;
    }

    public void setAnimalesList(List<Animales> animalesList) {
        this.animalesList = animalesList;
    }
}
