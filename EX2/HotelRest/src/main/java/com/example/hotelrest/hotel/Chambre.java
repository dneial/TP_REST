package com.example.hotelrest.hotel;

import java.io.Serializable;

public class Chambre implements Serializable {

    private int nbPlace;
    private int prix;
    private int numeroChambre;



    public Chambre(int nbPlace, int prix_hotel, int numeroChambre) {
        this.nbPlace = nbPlace;
        this.prix = nbPlace * 20 * prix_hotel;
        this.numeroChambre = numeroChambre;
    }


    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public static Chambre createChambre(int nbPlace, int prix_hotel, int numeroChambre){
        return new Chambre(nbPlace, prix_hotel, numeroChambre);
    }

    public String toString(){
        String s = "Chambre: \n";
        s += numeroChambre + "\n";
        s += "Nombre de places: " + nbPlace + "\n";
        s += "Prix par nuit: " + prix + "\n";
        return s;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chambre chambre = (Chambre) o;
        return nbPlace == chambre.nbPlace && prix == chambre.prix && numeroChambre == chambre.numeroChambre;
    }
}
