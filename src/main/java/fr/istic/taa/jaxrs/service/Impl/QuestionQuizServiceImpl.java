package fr.istic.taa.jaxrs.service.Impl;

import fr.istic.taa.jaxrs.entity.Kahoot;
import fr.istic.taa.jaxrs.entity.Reponse;
import fr.istic.taa.jaxrs.entity.QuestionQuiz;
import fr.istic.taa.jaxrs.dao.QuestionQuizDao;
import fr.istic.taa.jaxrs.service.QuestionQuizService;
import fr.istic.taa.jaxrs.service.ReponseService;

import java.util.List;

public class QuestionQuizServiceImpl implements QuestionQuizService {
    private final QuestionQuizDao questionQuizDao;
    private final ReponseService reponseService;

    public QuestionQuizServiceImpl(QuestionQuizDao questionQuizDao, ReponseService reponseService) {
        this.questionQuizDao = questionQuizDao;
        this.reponseService = reponseService;
    }


    @Override
    public void createQuestionQuiz(String questionLibelle, String reponse, Kahoot kahoot) {
        List<Reponse> reponses = reponseService.insertAndGetReponse(List.of("Oui","Non","Peut être"));

        QuestionQuiz questionQuiz = new QuestionQuiz(questionLibelle, reponse, reponses, kahoot);
        questionQuizDao.save(questionQuiz);

        reponses.stream().forEach(reponse1 -> {
            reponse1.setQuestion(questionQuiz);
            reponseService.save(reponse1);
        });
    }
}
