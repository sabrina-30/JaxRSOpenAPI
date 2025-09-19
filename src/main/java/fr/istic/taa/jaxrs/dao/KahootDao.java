package fr.istic.taa.jaxrs.dao;

import jakarta.persistence.EntityManager;
import fr.istic.taa.jaxrs.entity.Kahoot;

import java.util.List;

public class KahootDao {

    private EntityManager manager;

    public KahootDao(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Kahoot kahoot) {
        this.manager.persist(kahoot);
    }

    public List<Kahoot> findAll() {
        return this.manager.createQuery("from Kahoot", Kahoot.class).getResultList();
    }

    public Kahoot findById(int id) {
        return this.manager.find(Kahoot.class, id);
    }

    // Named Query
    public Kahoot findByCode(String code) {
        return this.manager.createNamedQuery("Kahoot.findByCode", Kahoot.class).setParameter("code", code).getSingleResult();
    }

    public void delete(Kahoot kahoot) {
        this.manager.remove(kahoot);
    }
}
