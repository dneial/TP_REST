package com.example.controllers;

import com.example.exceptions.HotelException;
import com.example.exceptions.HotelNotFoundException;
import com.example.models.Hotel;
import com.example.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;
    private static final String uri = "hotels/api";

    @GetMapping(uri + "/hotels")
    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    @GetMapping(uri + "/hotels/count")
    public long countHotels(){
        return hotelRepository.count();
    }

    @GetMapping(uri + "/hotels/{id}")
    public Hotel getHotelById(@PathVariable long id) throws HotelNotFoundException {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel with id " + id + " not found"));
    }

    @GetMapping(uri + "/hotels/critere/{ville}/{nbEtoile}")
    public List<Hotel> getHotelByCritere(@PathVariable String ville, @PathVariable int nbEtoile) throws HotelNotFoundException {
        List<Hotel> hotels = hotelRepository.findAll();
        List<Hotel> hotelsByCritere = new ArrayList<>();
        for(Hotel h : hotels){
            if(h.getAdresse().getVille().toLowerCase().equals(ville.toLowerCase())
                    && h.getNbEtoile() == nbEtoile){
                hotelsByCritere.add(h);
            }
        }
        if(hotelsByCritere.size() == 0){
            throw new HotelNotFoundException("No hotel found in " + ville);
        }

        return hotelsByCritere;
    }

    @GetMapping(uri + "/hotels/ville/{ville}")
    public List<Hotel> getHotelByVille(@PathVariable String ville) throws HotelNotFoundException {
        List<Hotel> hotels = hotelRepository.findAll();
        List<Hotel> hotelsByVille = new ArrayList<>();
        for(Hotel h : hotels){
            if(h.getAdresse().getVille().toLowerCase().equals(ville.toLowerCase())){
                hotelsByVille.add(h);
            }
        }
        if(hotelsByVille.size() == 0){
            throw new HotelNotFoundException("No hotel found in " + ville);
        }
        return hotelsByVille;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(uri + "/hotels")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelRepository.save(hotel);
    }

    @PutMapping(uri + "/hotels/{id}")
    public Hotel updateHotel(@PathVariable long id, @RequestBody Hotel hotel){
        return hotelRepository.findById(id)
                        .map(h -> {
                            h.setNom(hotel.getNom());
                            h.setAdresse(hotel.getAdresse());
                            h.setNbEtoile(hotel.getNbEtoile());
                            return hotelRepository.save(h);
                        })
                        .orElseGet(() -> {
                            return hotelRepository.save(hotel);
                        });
    }

    @DeleteMapping(uri + "/hotels/{id}")
    public void deleteHotel(@PathVariable long id) throws HotelNotFoundException{
        Hotel h = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel with id " + id + " not found"));
        hotelRepository.delete(h);
    }


}
