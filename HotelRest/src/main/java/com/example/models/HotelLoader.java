package com.example.models;

import java.io.*;
import java.util.ArrayList;

public class HotelLoader {
    private static final String dir = System.getProperty("user.dir") + "/src/main/resources/hotels/";

    public static void writeToFile(Hotel hotel){
        try {
            FileOutputStream fileOut = new FileOutputStream(dir + hotel.getNom().replace(" ", "_"));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(hotel);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Hotel> loadFromFiles(){
        ArrayList<Hotel> hotels = new ArrayList<>();
        File directory = new File(dir);
        File[] files = directory.listFiles();
        if(files == null) return hotels;

        for(File file : files){
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectInputStream
                        = new ObjectInputStream(fileIn);
                Hotel hotel = (Hotel) objectInputStream.readObject();
                hotels.add(hotel);
                fileIn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return hotels;
    }
}
