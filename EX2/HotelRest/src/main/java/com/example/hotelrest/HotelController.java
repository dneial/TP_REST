package com.example.hotelrest;

import com.example.hotelrest.hotel.Chambre;
import com.example.hotelrest.hotel.Hotel;
import com.example.hotelrest.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class HotelController {

    @Autowired
    private HotelRepository repository;
    private static final String uri = "hotel/api";

    @GetMapping("/chambres")
    ArrayList<Chambre> getChambres(@RequestParam(value="nbPlace", defaultValue = "1") int nbPlace,
                                   @RequestParam(value="prix", defaultValue = "0") int prix,
                                   @RequestParam(value="arrivee", defaultValue = "01/01/2000") Calendar dateArrivee,
                                   @RequestParam(value="depart", defaultValue = "02/01/2000") Calendar dateDepart)
    {
        ArrayList<Chambre> chambres = new ArrayList<>();

        return hotel.chambreDisponible(dateArrivee, dateDepart, nbPlace, prix);
    }
}
