package sir.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Alternant extends Personne{

    @ManyToOne
    private Entreprise entreprise;

    @ManyToOne
    private TuteurEntr tuteurEntr;

    @ManyToOne
    private TuteurUniv tuteurUniv;

    @ManyToOne
    @JoinColumn(name = "idFiliere")
    private FiliereAnnee filiereAnnee;

    @ManyToMany
    @JoinTable(name= "visiteAlternant",
            joinColumns={@JoinColumn(name= "idPersonne")},
            inverseJoinColumns= {@JoinColumn(name= "idVisite")})
    private List<Visite> visites;

    public Alternant() {
    }

    public Alternant(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public TuteurEntr getTuteurEntr() {
        return tuteurEntr;
    }

    public void setTuteurEntr(TuteurEntr tuteurEntr) {
        this.tuteurEntr = tuteurEntr;
    }

    public TuteurUniv getTuteurUniv() {
        return tuteurUniv;
    }

    public void setTuteurUniv(TuteurUniv tuteurUniv) {
        this.tuteurUniv = tuteurUniv;
    }

    public FiliereAnnee getFiliereAnnee() {
        return filiereAnnee;
    }

    public void setFiliereAnnee(FiliereAnnee filiereAnnee) {
        this.filiereAnnee = filiereAnnee;
    }

    public List<Visite> getVisites() {
        return visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }
}
