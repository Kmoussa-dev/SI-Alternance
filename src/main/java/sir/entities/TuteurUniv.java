package sir.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TuteurUniv extends Personne {

    @OneToMany(mappedBy = "tuteurUniv")
    private List<Alternant> alternants;

    public TuteurUniv() {
    }

    public TuteurUniv(String nom,String prenom,String email){
        super(nom,prenom,email);
    }

    public List<Alternant> getAlternants() {
        return alternants;
    }

    public void setAlternants(List<Alternant> alternants) {
        this.alternants = alternants;
    }
}
