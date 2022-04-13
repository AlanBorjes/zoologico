package utez.edu.mx.Zoologico.continent.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
    Optional<Continent> findByDescription(String description);
    boolean existsById(long id);
    void deleteById(long id);
}
