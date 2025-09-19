package fr.istic.taa.jaxrs.service.Impl;

import fr.istic.taa.jaxrs.entity.Kahoot;
import fr.istic.taa.jaxrs.entity.Utilisateur;
import fr.istic.taa.jaxrs.dao.KahootDao;
import fr.istic.taa.jaxrs.service.KahootService;

import java.util.List;

public class KahootServiceImpl implements KahootService {

    private final KahootDao kahootDao;

    public KahootServiceImpl(KahootDao kahootDao) {
        this.kahootDao = kahootDao;
    }

    @Override
    public void createKahoot(String code, List<Utilisateur> user){
        kahootDao.save(new Kahoot(code, user));
    }

    @Override
    public void save(Kahoot kahoot){
        kahootDao.save(kahoot);
    }

    @Override
    public Kahoot findKahootByCode(String code){
        return kahootDao.findByCode(code);
    }

}
