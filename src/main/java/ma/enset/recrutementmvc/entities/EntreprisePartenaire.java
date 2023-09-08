package ma.enset.recrutementmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
public class EntreprisePartenaire extends Utilisateur {

    private String adresse;
    private String logo;

    @OneToMany(mappedBy = "entreprise")
    private List<OffreEmploi> offresEmploi;

    // Getters and setters
}

