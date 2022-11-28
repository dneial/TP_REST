package com.example.models;


import jakarta.persistence.*;


@Entity
public class Chambre {

    @Id
    @GeneratedValue
    private long id;
    private int nbPlace;
    private int prix;
    private long hotel_id;

    @ManyToOne
    private Hotel hotel;


    public Chambre(long id, int nbPlace, long hotelId) {
        this.id = id;
        this.nbPlace = nbPlace;
        this.prix = nbPlace * 20;
        this.hotel_id = hotelId;
    }

    public Chambre() {

    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String toString(){
        String s = "Chambre: \n";
        s += "Nombre de places: " + nbPlace + "\n";
        s += "Prix par nuit: " + prix + "\n";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chambre chambre = (Chambre) o;
        return nbPlace == chambre.nbPlace
                && prix == chambre.prix;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }

    public long getHotelId() {
        return hotel_id;
    }

    public void setHotelId(long hotelId) {
        this.hotel_id = hotelId;
    }
}
