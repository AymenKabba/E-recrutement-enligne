package ma.enset.recrutementmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
public class Candidat extends Utilisateur {

    @ElementCollection
    private List<String> competences;

    @ElementCollection
    private List<String> qualifications;

    @OneToMany(mappedBy = "candidat")
    private List<Candidature> candidatures;

}


