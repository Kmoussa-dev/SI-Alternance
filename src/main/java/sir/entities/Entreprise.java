package sir.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Entreprise {
    @Id
    private String nom;

    private String siret;

    private String adresse;

    @OneToMany(mappedBy = "entreprise")
    private List<TuteurEntr> tuteurEntrs;

    @OneToMany(mappedBy = "entreprise")
    private List<Alternant> alternants;

    public Entreprise() {
    }

    public Entreprise(String nom) {
        this.nom = nom;
    }

    public Entreprise(String nom, String siret, String adresse) {
        this.nom = nom;
        this.siret = siret;
        this.adresse = adresse;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<TuteurEntr> getTuteurEntrs() {
        return tuteurEntrs;
    }

    public void setTuteurEntrs(List<TuteurEntr> tuteurEntrs) {
        this.tuteurEntrs = tuteurEntrs;
    }

    public List<Alternant> getAlternants() {
        return alternants;
    }

    public void setAlternants(List<Alternant> alternants) {
        this.alternants = alternants;
    }
}
