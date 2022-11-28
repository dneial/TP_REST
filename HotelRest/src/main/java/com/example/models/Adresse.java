package com.example.models;


import jakarta.persistence.*;
import java.util.Objects;

//@Entity
public class Adresse {

//    @Id
//    @GeneratedValue
    private long id;


    private String pays;
    private String ville;
    private String rue;
    private int numero;
    private String coorGPS;


    public Adresse(long id, String pays, String ville, String rue, int numero, String coorGPS) {
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.numero = numero;
        this.id = id;
        this.coorGPS = coorGPS;
    }

    public Adresse() {

    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays){
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville){
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue){
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public String getCoorGPS() {
        return coorGPS;
    }

    public void setCoorGPS(String coorGPS){
        this.coorGPS = coorGPS;
    }

    public String toString(){
        String s = numero + ", " + rue + "\n";
        s += ville + ", " + pays + "\n";
        return s;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return numero == adresse.numero && Objects.equals(pays, adresse.pays) &&
                Objects.equals(ville, adresse.ville) && Objects.equals(rue, adresse.rue) &&
                Objects.equals(coorGPS, adresse.coorGPS);
    }


}
