package sir.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Visite {

    @Id
    @GeneratedValue
    private int idVisite;

    private LocalDate dateVisite;

    private String commentaire;

    @ManyToMany(mappedBy = "visites")
    private List<Alternant> alternants;

    @ElementCollection
    private List<String> nomAutreParticipant;

    @ManyToOne
    @JoinColumn(name = "idModalite")
    private Modalite modalite;

    public Visite() {
    }

    public int getIdVisite() {
        return idVisite;
    }

    public void setIdVisite(int idVisite) {
        this.idVisite = idVisite;
    }

    public LocalDate getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(LocalDate dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public List<Alternant> getAlternants() {
        return alternants;
    }

    public void setAlternants(List<Alternant> alternants) {
        this.alternants = alternants;
    }

    public List<String> getNomAutreParticipant() {
        return nomAutreParticipant;
    }

    public void setNomAutreParticipant(List<String> nomAutreParticipant) {
        this.nomAutreParticipant = nomAutreParticipant;
    }

    public Modalite getModalite() {
        return modalite;
    }

    public void setModalite(Modalite modalite) {
        this.modalite = modalite;
    }
}
