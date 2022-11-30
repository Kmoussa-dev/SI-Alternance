package sir.controllers;

import sir.entities.Entreprise;
import sir.services.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class Controleur {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String root(){
        return "hello";
    }

    @GetMapping("createEntreprise")
    public String createEntrepriseGet(){
        return "createEntreprise";
    }

    @PostMapping("createEntreprise")
    public String createEntreprisePost(@RequestParam String siret, @RequestParam String nom, @RequestParam String adresse) {
        facade.creerEntreprise(nom,siret,adresse);
        return "hello";
    }

    @GetMapping("createModalite")
    public String createModaliteGet(){
        return "createModalite";
    }

    @PostMapping("createModalite")
    public String createModalitePost(@RequestParam String intitule){
        // TODO ajouter les paramètres de la méthode
        // TODO créer la méthode dans la facade
        facade.creeModalite(intitule);
        return "hello";
    }

    @GetMapping("createTuteurUniv")
    public String createTuteurUnivGet(Model model){
        // TODO les ajouter dans le modèle
//        model.addAttribute("tuteurs",facade.recupererTuteurs());
        return "createTU";
    }

    @PostMapping("createTU")
    public String createTuteurUnivPost(@RequestParam String nom,@RequestParam String prenom,@RequestParam String email){
        // TODO ajouter les paramètres de la méthode
        // TODO créer la méthode dans la facade
        facade.creerTuteursUniv(nom,prenom,email);
        return "hello";
    }

    @GetMapping("createTuteurEntr")
    public String createTuteurEntrGet(Model model){
        // TODO aller chercher la liste des entreprisesdans la facade
        // TODO les ajouter dans le modèle
//        model.addAttribute("")
        model.addAttribute("entreprises",facade.recupererEntreprise());
        return "createTE";
    }

    @PostMapping("createTE")
    public String createTuteurEntrPost(@RequestParam String nom, @RequestParam String prenom,
                                       @RequestParam String email, @RequestParam String telephone,
                                       @RequestParam String entreprise){
        // TODO ajouter les paramètres de la méthode
        // TODO créer la méthode dans la facade
        facade.creerTuteurEntr(nom,prenom,email,telephone,entreprise);
        return "hello";
    }


    @GetMapping("createAlt")
    public String createAltGet(Model model){
        // TODO aller chercher la liste des entreprises dans la facade
        // TODO les ajouter dans le modèle
        model.addAttribute("entreprises",facade.recupererEntreprise());
        return "createALT";
    }

    @PostMapping("createALT")
    public String createAltPost(Model model,@RequestParam String nom, @RequestParam String prenom,
                                @RequestParam String email,@RequestParam String entreprise){
        // TODO ajouter les paramètres de la méthode
        // TODO créer la méthode dans la facade
        facade.creerAlternant(nom,prenom,email,entreprise);
        return "completeALT";
    }

    @PostMapping("completeAlt")
    public String completeAltPost(@RequestParam int idAlt, @RequestParam int idTuteurU, @RequestParam int tuteurE){
        // TODO créer la méthode dans la facade
        facade.completeTuteurs(idAlt,idTuteurU,tuteurE);
        return "hello";
    }


    @GetMapping("plusAlternants")
    public String plusAnternants(Model model){
        // TODO devinez...
        model.addAttribute("e",facade.plusAlternant());
        return "plusAlternants";
    }

    @GetMapping("avecAlternants")
    public String parMotCle(Model model){
        // TODO devinez...
        return "avecAlternants";
    }
}
