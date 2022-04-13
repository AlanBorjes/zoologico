package utez.edu.mx.Zoologico.estado.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByDescription(String description);
    boolean existsById(long id);
    void deleteById(long id);
}
