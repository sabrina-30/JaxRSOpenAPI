package fr.istic.taa.jaxrs.dao;

import jakarta.persistence.EntityManager;
import fr.istic.taa.jaxrs.entity.QuestionSondage;

import java.util.List;

public class QuestionSondageDao {

    private EntityManager manager;

    public QuestionSondageDao(EntityManager manager){
        this.manager = manager;
    }

    public void save(QuestionSondage questionSondage){
        manager.persist(questionSondage);
    }

    public List<QuestionSondage> findAll(){
        return this.manager.createQuery("select qs from QuestionSondage qs",QuestionSondage.class).getResultList();
    }

    public QuestionSondage findById(int id){
        return this.manager.find(QuestionSondage.class, id);
    }
}
