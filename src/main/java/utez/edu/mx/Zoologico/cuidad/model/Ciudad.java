package utez.edu.mx.Zoologico.cuidad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;
import utez.edu.mx.Zoologico.estado.model.Estado;
import utez.edu.mx.Zoologico.zoologico.model.Zoologico;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    @NonNull
    private Estado estado;
    @OneToMany(mappedBy = "ciudadId")
    @JsonIgnore
    private List<Zoologico> zoologicoList;

    public Ciudad() {
    }

    public Ciudad(long id, String description, @NonNull Estado estado) {
        this.id = id;
        this.description = description;
        this.estado = estado;
    }

    public Ciudad(String description, @NonNull Estado estado) {
        this.description = description;
        this.estado = estado;
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
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(@NonNull Estado estado) {
        this.estado = estado;
    }

    public List<Zoologico> getZoologicoList() {
        return zoologicoList;
    }

    public void setZoologicoList(List<Zoologico> zoologicoList) {
        this.zoologicoList = zoologicoList;
    }
}
