package sir.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class TuteurEntr extends Personne{

    private String numTelephone;

    @ManyToOne
    private Entreprise entreprise;

    @OneToMany(mappedBy = "tuteurEntr")
    private List<Alternant> alternants;

    public TuteurEntr() {
    }

    public TuteurEntr(String nom, String prenom, String email, String numTelephone,Entreprise entreprise) {
        super(nom, prenom, email);
        this.numTelephone=numTelephone;
        this.entreprise= entreprise;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Alternant> getAlternants() {
        return alternants;
    }

    public void setAlternants(List<Alternant> alternants) {
        this.alternants = alternants;
    }
}
