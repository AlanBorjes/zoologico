package utez.edu.mx.Zoologico.especie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;
import utez.edu.mx.Zoologico.animales.model.Animales;
import utez.edu.mx.Zoologico.pais.model.Pais;

import javax.persistence.*;
import java.util.List;

@Entity
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreComun;
    private String nombreCientifico;
    private String familia;
    private String preligroExtincion;
    @ManyToOne
    @JoinColumn(name = "Pais_id", nullable = false)
    @NonNull
    private Pais pais;
    @OneToMany(mappedBy = "especie")
    @JsonIgnore
    private List<Animales> animales;


    public Especie() {
    }

    public Especie(long id, String nombreComun, String nombreCientifico, String familia, String preligroExtincion, @NonNull Pais pais) {
        this.id = id;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.familia = familia;
        this.preligroExtincion = preligroExtincion;
        this.pais = pais;
    }

    public Especie(String nombreComun, String nombreCientifico, String familia, String preligroExtincion, @NonNull Pais pais) {
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.familia = familia;
        this.preligroExtincion = preligroExtincion;
        this.pais = pais;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getPreligroExtincion() {
        return preligroExtincion;
    }

    public void setPreligroExtincion(String preligroExtincion) {
        this.preligroExtincion = preligroExtincion;
    }

    @NonNull
    public Pais getPais() {
        return pais;
    }

    public void setPais(@NonNull Pais pais) {
        this.pais = pais;
    }

    public List<Animales> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animales> animales) {
        this.animales = animales;
    }
}
