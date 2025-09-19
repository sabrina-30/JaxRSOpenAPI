package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    void save(Utilisateur u);

    List<Utilisateur> findAll();

    Utilisateur findByNomAndPrenom(String nom, String prenom);

    Utilisateur findById(Long id);

    void delete(Long id);
}
