package utez.edu.mx.Zoologico.estado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;
import utez.edu.mx.Zoologico.cuidad.model.Ciudad;
import utez.edu.mx.Zoologico.pais.model.Pais;
import utez.edu.mx.Zoologico.zoologico.model.Zoologico;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    @NonNull
    private Pais pais;
    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<Ciudad> ciudadList;

    public Estado() {
    }

    public Estado(String description, @NonNull Pais pais) {
        this.description = description;
        this.pais = pais;
    }

    public Estado(long id, String description, @NonNull Pais pais) {
        this.id = id;
        this.description = description;
        this.pais = pais;
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
    public Pais getPais() {
        return pais;
    }

    public void setPais(@NonNull Pais pais) {
        this.pais = pais;
    }

    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }
}
