package utez.edu.mx.Zoologico.sex.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SexRepository extends JpaRepository<Sex, Long> {
    Optional<Sex> findByDescription(String description);
    boolean existsById(long id);
    void deleteById(long id);
}
