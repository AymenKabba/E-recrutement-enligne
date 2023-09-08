package ma.enset.recrutementmvc.repositories;

import ma.enset.recrutementmvc.entities.ExperienceProfessionnelle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceProfessionnelleRepository extends JpaRepository<ExperienceProfessionnelle, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}

