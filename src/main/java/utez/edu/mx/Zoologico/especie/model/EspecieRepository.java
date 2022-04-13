package utez.edu.mx.Zoologico.especie.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecieRepository  extends JpaRepository<Especie, Long> {
    Optional<Especie> findByNombreCientifico(String name);
    boolean existsById(long id);
    void deleteById(long id);
}
