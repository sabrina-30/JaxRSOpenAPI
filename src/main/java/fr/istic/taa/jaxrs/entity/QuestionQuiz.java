package fr.istic.taa.jaxrs.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue("QUIZ")
public class QuestionQuiz extends Question {

    public QuestionQuiz() {}

    public QuestionQuiz(String questionDescription, String reponseReelle,
                        List<Reponse> reponsesPossibles,
                        Kahoot kahoot) {
        super(questionDescription, reponseReelle, reponsesPossibles,kahoot);
    }
}
