package ma.enset.recrutementmvc;

import ma.enset.recrutementmvc.entities.EntreprisePartenaire;
import ma.enset.recrutementmvc.entities.Role;
import ma.enset.recrutementmvc.entities.Utilisateur;
import ma.enset.recrutementmvc.repositories.EntreprisePartenaireRepository;
import ma.enset.recrutementmvc.repositories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RecrutementMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(RecrutementMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(UtilisateurRepository utilisateurRepository){
        return args -> {
        utilisateurRepository.save(new Utilisateur(null,"John","Doe","john.doe@example.com","password", Role.CANDIDAT));
        utilisateurRepository.save(new Utilisateur(null,"Alice", "Smith", "alice.smith@example.com", "password",Role.ADMINISTRATEUR));
        utilisateurRepository.save(new Utilisateur(null,"Eva", "Williams", "eva.williams@example.com", "password",Role.RECRUTEUR));
        utilisateurRepository.save(new Utilisateur(null,"Andre","King","andre.king@example.com","password",Role.CANDIDAT));

        utilisateurRepository.findAll().forEach(u ->{
            System.out.println(u.getNom());
        } );
        };
    }

    @Bean
    CommandLineRunner entreprisePartenaireCommandLineRunner(EntreprisePartenaireRepository entreprisePartenaireRepository) {
        return args -> {
            EntreprisePartenaire entreprise1 = new EntreprisePartenaire();
            entreprise1.setNom("TechCorp");
            entreprise1.setEmail("contact@techcorp.com");
            entreprise1.setMotDePasse("secret");
            entreprise1.setRole(Role.RECRUTEUR);
            entreprise1.setAdresse("123 Main St, City");
            entreprise1.setLogo("techcorp_logo.png");

            EntreprisePartenaire entreprise2 = new EntreprisePartenaire();
            entreprise2.setNom("SoftTech");
            entreprise2.setEmail("info@softtech.com");
            entreprise2.setMotDePasse("password");
            entreprise2.setRole(Role.RECRUTEUR);
            entreprise2.setAdresse("456 Elm St, Town");
            entreprise2.setLogo("softtech_logo.png");

            entreprisePartenaireRepository.saveAll(Arrays.asList(entreprise1, entreprise2));

            entreprisePartenaireRepository.findAll().forEach(ep -> {
                System.out.println(ep.getNom());
            });
        };
    }

}
