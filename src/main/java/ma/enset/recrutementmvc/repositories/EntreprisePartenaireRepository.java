package ma.enset.recrutementmvc.repositories;

import ma.enset.recrutementmvc.entities.EntreprisePartenaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntreprisePartenaireRepository extends JpaRepository<EntreprisePartenaire, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}

