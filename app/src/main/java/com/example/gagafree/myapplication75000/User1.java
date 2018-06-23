package com.example.gagafree.myapplication75000;

/**
 * Created by gagafree on 08/03/2018.
 */

public class User1 {

    String message;
    String mydate;



    public User1() {

    }

    public User1(String message, String mydate ) {

        this.message =message;
        this.mydate = mydate;


    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String nom) {
        this.message = message;
    }

    public String getMydate() {
        return mydate;
    }

    public void setMydate(String prenom) {

        this.mydate = prenom;
    }


}
