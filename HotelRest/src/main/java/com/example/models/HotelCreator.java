package com.example.models;

import java.util.ArrayList;
import java.util.Random;

public class HotelCreator {
    static private String[] h_names = {"Hotel BG", "Hotel Lamarck", "Hotel de la Paix", "Hotel de la Guerre",
                                        "Hotel Schon", "Hotel Pisser","Hotel Kleiner", "Hotel Apache",
                                        "Hotel Bonito", "Hotel Boa Vista", "Hotel do Mar", "Hotel do Sol",
                                        "Hotel del Mar", "Hotel de la Playa", "Hotel de la Costa", "Hotel de la Isla",};

    private ArrayList<Adresse> addrs = createAdresses();

    private ArrayList<Adresse> createAdresses(){
        ArrayList<Adresse> addrs = new ArrayList<>();
        Adresse f1 = new Adresse("France", "Paris", "Rue des Papillons", 1, "75001");
        addrs.add(f1);
        Adresse f2 = new Adresse("France", "Paris", "Avenue de la République", 2, "75002");
        addrs.add(f2);
        Adresse f3 = new Adresse("France", "Montpellier", "Rue des Papillons", 3, "34000");
        addrs.add(f3);
        Adresse f4 = new Adresse("France", "Montpellier", "Avenue de la République", 4, "34001");
        addrs.add(f4);
        Adresse a1 = new Adresse("Allemagne", "Berlin", "Scheiss Streiss", 5, "10000");
        addrs.add(a1);
        Adresse a2 = new Adresse("Allemagne", "Berlin", "Schon Streiss", 6, "10001");
        addrs.add(a2);
        Adresse a3 = new Adresse("Allemagne", "Munich", "Scheiss Streiss", 7, "20000");
        addrs.add(a3);
        Adresse a4 = new Adresse("Allemagne", "Munich", "Schon Streiss", 8, "20001");
        addrs.add(a4);
        Adresse b1 = new Adresse("Brasil", "Rio de Janeiro", "Rua Bonita", 9, "30000");
        addrs.add(b1);
        Adresse b2 = new Adresse("Brasil", "Rio de Janeiro", "Avenida da Boa Vista", 10, "30001");
        addrs.add(b2);
        Adresse b3 = new Adresse("Brasil", "Sao Paulo", "Rua Bonita", 11, "40000");
        addrs.add(b3);
        Adresse b4 = new Adresse("Brasil", "Sao Paulo", "Avenida da Boa Vista", 12, "40001");
        addrs.add(b4);
        Adresse e1 = new Adresse("Espagne", "Valencia", "Calle del Castillo", 13, "50000");
        addrs.add(e1);
        Adresse e2 = new Adresse("Espagne", "Valencia", "Calle Grande", 14, "50001");
        addrs.add(e2);
        Adresse e3 = new Adresse("Espagne", "Barcelona", "Calle del Castillo", 15, "60000");
        addrs.add(e3);
        Adresse e4 = new Adresse("Espagne", "Barcelona", "Calle Grande", 16, "60001");
        addrs.add(e4);
        return addrs;
    }

    public ArrayList<Hotel> createHotels(){
        ArrayList<Hotel> hotels = new ArrayList<>();
        int i = 0;
        Random rand = new Random();
        for(String n: h_names){
            hotels.add(new Hotel(n, addrs.get(i++), rand.nextInt(4) + 1));
        }
        return hotels;
    }

    public static void main(String[] args) {
        HotelCreator hc = new HotelCreator();
        for(Hotel h: hc.createHotels()){
            HotelLoader.writeToFile(h);
        }
    }
}
