package fr.istic.taa.jaxrs.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Question {

    private Long id;

    private String questionDescription;

    private String reponseReelle ;

    private List<Reponse> reponsesPossibles = new ArrayList<>();

    private Kahoot kahoot;

    // CONSTRUCTOR
    public Question(){

    }

    public Question(String questionDescription,
                    String reponseReelle,
                    List<Reponse> reponsesPossibles,
                    Kahoot kahoot) {
        this.questionDescription = questionDescription;
        this.reponseReelle = reponseReelle;
        this.reponsesPossibles = reponsesPossibles;
        this.kahoot = kahoot;
    }

    //GETTER SETTER

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getReponseReelle() {
        return reponseReelle;
    }

    public void setReponseReelle(String reponseReelle) {
        this.reponseReelle = reponseReelle;
    }

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    public List<Reponse> getReponsesPossibles() {
        return reponsesPossibles;
    }

    public void setReponsesPossibles(List<Reponse> reponsesPossibles) {
        this.reponsesPossibles = reponsesPossibles;
    }

    @ManyToOne
    public Kahoot getKahoot() {
        return kahoot;
    }

    public void setKahoot(Kahoot kahoot) {
        this.kahoot = kahoot;
    }
}
