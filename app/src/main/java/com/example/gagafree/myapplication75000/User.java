package com.example.gagafree.myapplication75000;

/**
 * Created by gagafree on 08/03/2018.
 */

public class User {

    String nom;
    String prenom;
    String mydate;


    public User() {

    }

    public User(String nom, String prenom, String mydate ) {

        this.nom =nom;
        this.prenom = prenom;
        this.mydate = mydate;

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

    public String getMydate() {
        return mydate;
    }

    public void setMydate(String mydate) {
        this.mydate = mydate;
    }
}
