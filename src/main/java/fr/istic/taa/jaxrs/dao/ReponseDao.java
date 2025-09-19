package fr.istic.taa.jaxrs.dao;

import jakarta.persistence.EntityManager;
import fr.istic.taa.jaxrs.entity.Reponse;

import java.util.List;

public class ReponseDao {

    private EntityManager manager;

    public ReponseDao(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Reponse reponse) {
        this.manager.persist(reponse);
    }

    public void delete(Reponse reponse) {
        this.manager.remove(reponse);
    }

    //  Named query defined in entity Reponse
    public List<Reponse> findAll() {
        return manager.createNamedQuery("Reponse.findAll", Reponse.class).getResultList();
    }

    public List<Reponse> findByReponseLibelleIn(List<String> reponseLibelle){
        return manager.createNamedQuery("Reponse.findByReponseLibelleIn",Reponse.class).setParameter("reponseLibelle",reponseLibelle).getResultList();
    }

}
