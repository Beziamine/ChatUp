package com.example.gagafree.myapplication75000;

/**
 * Created by gagafree on 08/03/2018.
 */

public class Register {

    String nom;
    String number;
    String password;
    String mydate;


    public Register() {

    }

    public Register(String nom, String number, String password, String mydate ) {

        this.nom =nom;
        this.number = number;
        this.mydate = mydate;
        this.password = password;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMydate() {
        return mydate;
    }

    public void setMydate(String mydate) {
        this.mydate = mydate;
    }
}
