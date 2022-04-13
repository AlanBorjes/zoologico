package utez.edu.mx.Zoologico.zoologico.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZoologicoRepository extends JpaRepository<Zoologico, Long> {
    Optional<Zoologico> findByName(String name);
    boolean existsById(long id);
    void deleteById(long id);
}
