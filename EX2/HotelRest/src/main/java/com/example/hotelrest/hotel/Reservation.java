package com.example.hotelrest.hotel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public class Reservation implements Serializable {

    private String nomClient;
    private Chambre chambre;
    private Calendar dateDebut;
    private Calendar dateFin;

    public Reservation(String nom, Chambre chambre, Calendar dateDebut, Calendar dateFin) {
        this.nomClient = nom;
        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getNomClient() {
        return nomClient;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Calendar getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Calendar dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Calendar getDateFin() {
        return dateFin;
    }

    public void setDateFin(Calendar dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(nomClient, that.nomClient) && Objects.equals(chambre, that.chambre) &&
                Objects.equals(dateDebut, that.dateDebut) && Objects.equals(dateFin, that.dateFin);
    }
}
