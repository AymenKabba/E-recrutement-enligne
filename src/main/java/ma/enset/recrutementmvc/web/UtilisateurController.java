package ma.enset.recrutementmvc.web;

import ma.enset.recrutementmvc.entities.Utilisateur;
import ma.enset.recrutementmvc.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @GetMapping
    public String listUtilisateurs(Model model ,
                                   @RequestParam(name = "page" , defaultValue = "0") int page ,
                                   @RequestParam(name = "size" , defaultValue = "5") int size ,
                                   @RequestParam(name="keyword",defaultValue = "") String keyword){
        Page<Utilisateur> Pageutilisateurs = utilisateurRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("utilisateurs", Pageutilisateurs.getContent());
        model.addAttribute("pages", new int[Pageutilisateurs.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword",keyword);
        return "utilisateur/list";
    }

    @GetMapping("/{id}")
    public String viewUtilisateur(@PathVariable Long id, Model model) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            model.addAttribute("utilisateur", utilisateur.get());
            return "utilisateur/view";
        } else {
            // Gérer le cas où l'utilisateur n'existe pas
            return "redirect:/utilisateurs";
        }
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerUtilisateur(@PathVariable Long id, @RequestParam String keyword, @RequestParam int page) {
        // Supprimez l'utilisateur de la base de données s'il existe
        utilisateurRepository.deleteById(id);

        // Redirigez l'utilisateur vers la liste des utilisateurs après la suppression
        return "redirect:/utilisateurs?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/utilisateurs";
    }

    @GetMapping("/list")
    public String list(Model model) {
        // Populate your model data here
        return "utilisateur/list";
    }

}

