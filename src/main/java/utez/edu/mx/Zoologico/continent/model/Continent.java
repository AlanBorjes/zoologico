package utez.edu.mx.Zoologico.continent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import utez.edu.mx.Zoologico.pais.model.Pais;

import javax.persistence.*;
import java.util.List;

@Entity
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @OneToMany(mappedBy = "continent")
    @JsonIgnore
    private List<Pais> paisList;

    public Continent() {
    }

    public Continent(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Continent(String description) {
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
}
