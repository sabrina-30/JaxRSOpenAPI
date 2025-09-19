package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.entity.Kahoot;

public interface QuestionQuizService {

    void createQuestionQuiz(String questionLibelle, String reponse, Kahoot kahoot);
}
