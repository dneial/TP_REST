package com.example.hotelrest.hotel;


import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class Hotel implements Serializable {

    private long id;

    private String nom;
    private Adresse adresse;
    private int nbEtoile;
    private ArrayList<Chambre> chambres;
    private ArrayList<Reservation> reservations;

    public Hotel() {
    }

    public Hotel(String nom, Adresse adresse, int nbEtoile) {
        this.nom = nom;
        this.adresse = adresse;
        this.nbEtoile = nbEtoile;
        this.chambres = createChambres();
        this.reservations = new ArrayList<>();
    }

    private ArrayList<Chambre> createChambres() {
        ArrayList<Chambre> chambres = new ArrayList<>();

        chambres.add(Chambre.createChambre(2, nbEtoile,1));
        chambres.add(Chambre.createChambre(2, nbEtoile,2));
        chambres.add(Chambre.createChambre(3, nbEtoile, 3));
        chambres.add(Chambre.createChambre(3, nbEtoile, 4));
        chambres.add(Chambre.createChambre(4, nbEtoile,5));
        chambres.add(Chambre.createChambre(4, nbEtoile,6));
        return chambres;
    }

    public String getNom() {
        return nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public int getNbEtoile() {
        return nbEtoile;
    }

    public void setNbEtoile(int nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public ArrayList<Chambre> chambreDisponible(Calendar dateArrive, Calendar dateRetour, int nbPlace, int prix){
        ArrayList<Chambre> chambreLibre = filterChambres(nbPlace, prix);
        ArrayList<Chambre> chambreDisponible = new ArrayList<>();
        for (Chambre c: chambreLibre) {
            boolean verif = true;
            for (Reservation r : reservations) {
                if (r.getChambre().equals(c))
                    if (!dateArrive.after(r.getDateFin()) || !r.getDateDebut().before(dateRetour))
                        verif = false;
            }
            if (verif) chambreDisponible.add(c);
        }
        return chambreDisponible;
    }

    private ArrayList<Chambre> filterChambres(int nbPlace, int prix){
        if (prix == 0) prix = Integer.MAX_VALUE;
        ArrayList<Chambre> chambreLibre = new ArrayList<>();
        for (Chambre c: chambres) {
            if(c.getNbPlace() >= nbPlace){
                if (c.getPrix() <= prix){
                    chambreLibre.add(c);
                }
            }
        }
        return chambreLibre;
    }
    public void createReservation(String nomClient, Chambre chambre, Calendar debut, Calendar fin){
        Reservation r = new Reservation(nomClient, chambre, debut, fin);
        addReservation(r);
        System.out.println(
                "Reservation de " + r.getNomClient() + " pour la chambre " + r.getChambre().getNumeroChambre() +
                        " du " + r.getDateDebut().getTime() + " au " + r.getDateFin().getTime() + " effectuée");

    }

    public Hotel addReservation(Reservation reservation){
        reservations.add(reservation);
        return this;
    }

    public Hotel delReservation(Reservation reservation){
        reservations.remove(reservation);
        return this;
    }

    public Hotel addChambre(Chambre chambre){
        chambres.add(chambre);
        return this;
    }

    public Hotel delChambre(Chambre chambre){
        chambres.remove(chambre);
        return this;
    }

    public String toString(){
        String s = "hotel " + nom + "\n";
        for(int i = 0; i<nbEtoile; i++) s += "*";
        s += "\nHotel.Adresse: " + adresse.toString();
        return s;
    }

    public Chambre getChambre(int numeroChambre){
        for (Chambre c: chambres) {
            if (c.getNumeroChambre() == numeroChambre){
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return nbEtoile == hotel.nbEtoile && Objects.equals(nom, hotel.nom) &&
                Objects.equals(adresse, hotel.adresse) && Objects.equals(chambres, hotel.chambres) &&
                Objects.equals(reservations, hotel.reservations);
    }
}
