package fr.istic.taa.jaxrs.service.Impl;

import fr.istic.taa.jaxrs.entity.Kahoot;
import fr.istic.taa.jaxrs.entity.QuestionSondage;
import fr.istic.taa.jaxrs.dao.QuestionSondageDao;
import fr.istic.taa.jaxrs.entity.Reponse;
import fr.istic.taa.jaxrs.service.QuestionSondageService;
import fr.istic.taa.jaxrs.service.ReponseService;

import java.util.List;

public class QuestionSondageServiceImpl implements QuestionSondageService {

    private QuestionSondageDao questionSondageDao;
    private ReponseService reponseService;


    public QuestionSondageServiceImpl(QuestionSondageDao questionSondageDao, ReponseService reponseService) {
        this.questionSondageDao = questionSondageDao;
        this.reponseService = reponseService;
    }


    @Override
    public void createQuestionSondage(String questionLibelle, String reponse, Kahoot kahoot) {
        List<Reponse> reponses = reponseService.insertAndGetReponse(List.of(">","<","=",">=","<="));

        QuestionSondage questionSondage = new QuestionSondage(questionLibelle,reponse,reponses,kahoot);
        questionSondageDao.save(questionSondage);

        reponses.stream().forEach(reponse1 -> {
            reponse1.setQuestion(questionSondage);
            reponseService.save(reponse1);
        });

    }
}
