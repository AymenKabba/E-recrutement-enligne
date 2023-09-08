package ma.enset.recrutementmvc.repositories;

import ma.enset.recrutementmvc.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
    Page<Utilisateur> findByNomContains(String kw, Pageable pageable);
}
