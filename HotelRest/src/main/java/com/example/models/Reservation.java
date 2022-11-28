package com.example.models;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Objects;

@Entity
public class Reservation  {

    @Id
    @GeneratedValue
    private long id;

    private String nomClient;

/*    @ManyToOne
    private Chambre chambre;*/

    private Calendar dateDebut;
    private Calendar dateFin;

    @ManyToOne
    private Hotel hotel;


    public Reservation(String nom, Calendar dateDebut, Calendar dateFin) {
        this.nomClient = nom;
        //this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Reservation() {

    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

/*    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }*/

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
        return Objects.equals(nomClient, that.nomClient)
                //&& Objects.equals(chambre, that.chambre)
                && Objects.equals(dateDebut, that.dateDebut)
                && Objects.equals(dateFin, that.dateFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomClient, dateDebut, dateFin);
    }
}
