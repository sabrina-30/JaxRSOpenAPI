package fr.istic.taa.jaxrs.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur {

    Long id;

    String nom;

    String prenom;

    List<Kahoot> kahoots = new ArrayList<>();

    // CONSTRUCTOR

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }


    // GETTER & SETTER

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @ManyToMany(mappedBy = "utilisateurs")
    public List<Kahoot> getKahoots() {
        return kahoots;
    }

    public void setKahoots(List<Kahoot> kahoots) {
        this.kahoots = kahoots;
    }

    public String printNomPrenom(){
        return nom + " " + prenom;
    }

}
