package utez.edu.mx.Zoologico.pais.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;
import utez.edu.mx.Zoologico.continent.model.Continent;
import utez.edu.mx.Zoologico.especie.model.Especie;
import utez.edu.mx.Zoologico.estado.model.Estado;
import utez.edu.mx.Zoologico.zoologico.model.Zoologico;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "continent_id", nullable = false)
    @NonNull
    private Continent continent;
    @OneToMany(mappedBy = "pais")
    @JsonIgnore
    private List<Estado> estadoList;
    @OneToMany(mappedBy = "pais")
    @JsonIgnore
    private List<Especie> especieList;

    public Pais(long id, String description, @NonNull Continent continent) {
        this.id = id;
        this.description = description;
        this.continent = continent;
    }

    public Pais(String description, @NonNull Continent continent) {
        this.description = description;
        this.continent = continent;
    }

    public Pais() {

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

    @NonNull
    public Continent getContinent() {
        return continent;
    }

    public void setContinent(@NonNull Continent continent) {
        this.continent = continent;
    }

    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }
}
