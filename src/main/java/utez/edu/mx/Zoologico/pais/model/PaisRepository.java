package utez.edu.mx.Zoologico.pais.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    Optional<Pais> findByDescription(String description);
    boolean existsById(long id);
    void deleteById(long id);
}
