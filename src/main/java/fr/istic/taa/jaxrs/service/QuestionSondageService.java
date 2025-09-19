package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.entity.Kahoot;

public interface QuestionSondageService {

    void createQuestionSondage(String questionLibelle, String reponse, Kahoot kahoot);

}
