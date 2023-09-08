package ma.enset.recrutementmvc.repositories;

import ma.enset.recrutementmvc.entities.OffreEmploi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreEmploiRepository extends JpaRepository<OffreEmploi, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}

