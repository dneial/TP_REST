package com.example.models;


import java.io.Serializable;
import java.util.Objects;

public class Adresse implements Serializable {

    private String pays;
    private String ville;
    private String rue;
    private int numero;
    private String CoorGPS;

    public Adresse(String pays, String ville, String rue, int numero, String coorGPS) {
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.numero = numero;
        CoorGPS = coorGPS;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }

    public int getNumero() {
        return numero;
    }

    public String getCoorGPS() {
        return CoorGPS;
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
                Objects.equals(CoorGPS, adresse.CoorGPS);
    }
}
