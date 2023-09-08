package ma.enset.recrutementmvc.repositories;

import ma.enset.recrutementmvc.entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}

