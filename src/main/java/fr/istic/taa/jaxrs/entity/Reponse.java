package fr.istic.taa.jaxrs.entity;

import jakarta.persistence.*;

@Entity
@NamedQuery(name="Reponse.findAll",query = "select r from Reponse r")
@NamedQuery(name="Reponse.findByReponseLibelleIn",query = "select r from Reponse r where r.reponseLibelle in :reponseLibelle")
public class Reponse {

    Long id;

    String reponseLibelle;

    Question question;

    // CONSTRUCTOR

    public Reponse(){

    }

    public Reponse(String reponseLibelle) {
        this.reponseLibelle = reponseLibelle;
    }


    // GETTER SETTER

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReponseLibelle() {
        return reponseLibelle;
    }

    public void setReponseLibelle(String reponseLibelle) {
        this.reponseLibelle = reponseLibelle;
    }

    @ManyToOne
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }



}
