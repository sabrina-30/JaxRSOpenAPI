package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.entity.Kahoot;
import fr.istic.taa.jaxrs.entity.Utilisateur;

import java.util.List;

public interface KahootService {
    void createKahoot(String code, List<Utilisateur> user);
    void save(Kahoot kahoot);
    Kahoot findKahootByCode(String code);
}
