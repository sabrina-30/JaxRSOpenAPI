package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.entity.Reponse;

import java.util.List;

public interface ReponseService {


    List<Reponse> insertAndGetReponse(List<String> reponseLibelle);

    void save(Reponse reponse);
}
