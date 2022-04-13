package utez.edu.mx.Zoologico.animales.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalesRepository extends JpaRepository<Animales, Long> {
    Optional<Animales> findByClaveAnimal(String clave);
    boolean existsById(long id);
    void deleteById(long id);
}
