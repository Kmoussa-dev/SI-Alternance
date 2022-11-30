package sir.services;

import org.springframework.stereotype.Service;
import sir.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class Facade {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void creerEntreprise(String nom, String siret, String adresse) {
        em.persist(new Entreprise(nom,siret,adresse));
    }
    @Transactional
    public void creeModalite(String intitule) {
        em.persist(new Modalite(intitule));
    }
    @Transactional
    public void creerTuteursUniv(String nom, String prenom, String email) {
        em.persist(new TuteurUniv(nom,prenom,email));
    }
    @Transactional
    public void creerTuteurEntr(String nom, String prenom, String email, String telephone, String entreprise) throws EntityNotFoundException {
        Entreprise entreprise1=new Entreprise(entreprise);
        em.persist(entreprise1);
        em.persist(new TuteurEntr(nom,prenom,email,telephone,entreprise1));
    }

    public List<Entreprise> recupererEntreprise() {
        Query query= em.createQuery("select e from Entreprise e");
        return query.getResultList();
    }

    @Transactional
    public void creerAlternant(String nom, String prenom, String email, String nomEntr) throws EntityNotFoundException {
        Alternant alternant=new Alternant(nom,prenom,email);
        Query query = em.createQuery("select e from Entreprise e where e.nom=:nomEntr");
        query.setParameter("nomEntr",nomEntr);
        Entreprise entreprise=(Entreprise) query.getSingleResult();
        alternant.setEntreprise(entreprise);
        em.persist(alternant);
    }

    public List<Alternant> recupererAlternants() {
        Query query= em.createQuery("select a from Alternant a");
        return query.getResultList();
    }

    public void completeTuteurs(int idAlt, int idTuteurU, int tuteurE) {
    }

    public Entreprise plusAlternant() {
        Query query=em.createQuery("SELECT e FROM Entreprise e WHERE e.alternants.size = (SELECT MAX(x.alternants.size) FROM Entreprise x WHERE e = x)");
        return (Entreprise) query.getSingleResult();
    }
}
