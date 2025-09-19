package fr.istic.taa.jaxrs.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue("SONDAGE")
public class QuestionSondage extends Question {

    public QuestionSondage() {}

    public QuestionSondage(String questionDescription, String reponseReelle,
                           List<Reponse> reponsesPossibles,
                           Kahoot kahoot) {
        super(questionDescription,reponseReelle,reponsesPossibles,kahoot);
    }
}
