package ma.enset.recrutementmvc.repositories;

import ma.enset.recrutementmvc.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}

