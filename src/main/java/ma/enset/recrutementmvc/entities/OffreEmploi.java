package ma.enset.recrutementmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreEmploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private double salaire;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private EntreprisePartenaire entreprise;

    // Getters and setters
}

