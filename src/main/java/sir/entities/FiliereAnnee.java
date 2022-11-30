package sir.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class FiliereAnnee {

    @Id
    @GeneratedValue
    private int idFiliere;

    private String nomFiliere;

    private String annee;

    @OneToMany(mappedBy = "filiereAnnee")
    private List<Alternant> alternants;

    public FiliereAnnee() {
    }

    public int getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public List<Alternant> getAlternants() {
        return alternants;
    }

    public void setAlternants(List<Alternant> alternants) {
        this.alternants = alternants;
    }
}
