package sir.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Modalite {

    @Id
    @GeneratedValue
    private int idModalite;

    private String intituleModalite;

    @OneToMany(mappedBy = "modalite")
    private List<Visite> visites;

    public Modalite() {
    }

    public Modalite(String intituleModalite) {
        this.intituleModalite = intituleModalite;
    }

    public int getIdModalite() {
        return idModalite;
    }

    public void setIdModalite(int idModalite) {
        this.idModalite = idModalite;
    }

    public String getIntituleModalite() {
        return intituleModalite;
    }

    public void setIntituleModalite(String intituleModalite) {
        this.intituleModalite = intituleModalite;
    }

    public List<Visite> getVisites() {
        return visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }
}
