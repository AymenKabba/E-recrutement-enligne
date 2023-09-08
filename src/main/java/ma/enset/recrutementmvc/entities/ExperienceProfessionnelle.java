package ma.enset.recrutementmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
public class ExperienceProfessionnelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String poste;
    private String entreprise;
    @Temporal(TemporalType.DATE)

    private Date dateDebut;

    @Temporal(TemporalType.DATE)

    private Date dateFin;
    private String description;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;

    // Getters and setters
}
