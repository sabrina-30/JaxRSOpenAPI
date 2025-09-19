package fr.istic.taa.jaxrs.service.Impl;

import fr.istic.taa.jaxrs.entity.Reponse;
import fr.istic.taa.jaxrs.dao.ReponseDao;
import fr.istic.taa.jaxrs.service.ReponseService;

import java.util.List;

public class ReponseServiceImpl implements ReponseService {

    private ReponseDao reponseDao;

    public ReponseServiceImpl(ReponseDao reponseDao) {
        this.reponseDao = reponseDao;
    }

    public List<Reponse> insertAndGetReponse(List<String> reponseLibelle){
        reponseLibelle.forEach(libelle -> {
            Reponse rep = new Reponse(libelle);
            reponseDao.save(rep);
        });

        // using named query
        return reponseDao.findByReponseLibelleIn(reponseLibelle);
    }

    @Override
    public void save(Reponse reponse) {
        reponseDao.save(reponse);
    }
}
