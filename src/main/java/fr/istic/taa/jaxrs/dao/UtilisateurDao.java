package fr.istic.taa.jaxrs.dao;

import jakarta.persistence.EntityManager;
import fr.istic.taa.jaxrs.entity.Utilisateur;

import java.util.List;

public class UtilisateurDao {

    private EntityManager manager;

    public UtilisateurDao(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Utilisateur utilisateur) {
        this.manager.persist(utilisateur);
    }


    public List<Utilisateur> findAll() {
        return this.manager.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
    }


    public Utilisateur findById(Long id) {
        return this.manager.find(Utilisateur.class, id);
    }

    public Utilisateur findByNomAndPrenom(String nom, String prenom) {
        return this.manager.createQuery("select u from Utilisateur u where u.nom = :nom and u.prenom = :prenom", Utilisateur.class)
                .setParameter("nom", nom)
                .setParameter("prenom", prenom)
                .getResultList().stream().findFirst().orElse(null);
    }

    public void deleteById(Long id) {
        this.manager.remove(this.findById(id));
    }

}
