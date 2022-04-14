package utez.edu.mx.Zoologico.zoologico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;
import utez.edu.mx.Zoologico.animales.model.Animales;
import utez.edu.mx.Zoologico.cuidad.model.Ciudad;
import utez.edu.mx.Zoologico.especie.model.Especie;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zoologico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String tamano;
    private String presupuesto;
    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    @NonNull
    private Ciudad ciudadId;
    @OneToMany(mappedBy = "zoologico")
    @JsonIgnore
    private List<Animales> animalesList;


    public Zoologico() {
    }

    public Zoologico(long id, String name,  String tamano, String presupuesto, @NonNull Ciudad ciudadId) {
        this.id = id;
        this.name = name;

        this.tamano = tamano;
        this.presupuesto = presupuesto;
        this.ciudadId = ciudadId;
    }

    public Zoologico(String name, String tamano, String presupuesto, @NonNull Ciudad ciudadId) {
        this.name = name;

        this.tamano = tamano;
        this.presupuesto = presupuesto;
        this.ciudadId = ciudadId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    @NonNull
    public Ciudad getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(@NonNull Ciudad ciudadId) {
        this.ciudadId = ciudadId;
    }

    public List<Animales> getAnimalesList() {
        return animalesList;
    }

    public void setAnimalesList(List<Animales> animalesList) {
        this.animalesList = animalesList;
    }
}

