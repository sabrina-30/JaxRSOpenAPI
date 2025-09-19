package fr.istic.taa.jaxrs.dao;

import jakarta.persistence.EntityManager;
import fr.istic.taa.jaxrs.entity.QuestionQuiz;

import java.util.List;

public class QuestionQuizDao {

    private EntityManager manager;

    public QuestionQuizDao(EntityManager manager) {
        this.manager = manager;
    }

    public void save(QuestionQuiz questionQuiz){
        this.manager.persist(questionQuiz);
    }


    public QuestionQuiz findById(int id){
        return this.manager.find(QuestionQuiz.class, id);
    }

    public List<QuestionQuiz> findAll(){
        return this.manager.createQuery("select qq from QuestionQuiz qq",QuestionQuiz.class).getResultList();
    }
}
