package fr.istic.taa.jaxrs.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="Kahoot.findByCode",query = "select k from Kahoot k where k.code=:code")
public class Kahoot {

    Long id;

    String code;

    List<Question> questions = new ArrayList<>();

    List<Utilisateur> utilisateurs = new ArrayList<>();

    // CONSTRUCTOR
    public Kahoot(){

    }

    public Kahoot(String code, List<Utilisateur> utilisateurs) {
        this.code = code;
        this.utilisateurs = utilisateurs;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @OneToMany(mappedBy = "kahoot", cascade = CascadeType.PERSIST)
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @ManyToMany
    @JoinTable(
            name = "kahoot_utilisateur",
            joinColumns = @JoinColumn(name = "kahoot_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }



}
