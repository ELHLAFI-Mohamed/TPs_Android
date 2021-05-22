package com.example.tp1arrayadapater;

public class Contact{
    String Nom;
    String Prenom;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact(int id1,String nom, String prenom) {
        Nom = nom;
        Prenom=prenom;
        id=id1;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
}
