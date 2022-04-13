package utez.edu.mx.Zoologico.cuidad.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    Optional<Ciudad> findByDescription(String description);
    boolean existsById(long id);
    void deleteById(long id);
}
