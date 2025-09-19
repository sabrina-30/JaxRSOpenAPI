package fr.istic.taa.jaxrs.service.Impl;

import fr.istic.taa.jaxrs.entity.Utilisateur;
import fr.istic.taa.jaxrs.dao.UtilisateurDao;
import fr.istic.taa.jaxrs.service.UtilisateurService;

import java.util.List;

public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurDao utilisateurDao;

    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public void save(Utilisateur u) {
        this.utilisateurDao.save(u);
    }

    @Override
    public List<Utilisateur> findAll() {
        return this.utilisateurDao.findAll();
    }

    @Override
    public Utilisateur findByNomAndPrenom(String nom, String prenom) {
        return this.utilisateurDao.findByNomAndPrenom(nom, prenom);
    }

    @Override
    public Utilisateur findById(Long id) {
        return this.utilisateurDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.utilisateurDao.deleteById(id);
    }
}
