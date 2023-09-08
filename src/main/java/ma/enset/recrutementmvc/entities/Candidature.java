package ma.enset.recrutementmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateSoumission;
    private EtatCandidature etat;

    @ManyToOne
    @JoinColumn(name = "candidat_id") // Colonne de clé étrangère vers Candidat
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private OffreEmploi offreEmploi;

    // Getters and setters
}


