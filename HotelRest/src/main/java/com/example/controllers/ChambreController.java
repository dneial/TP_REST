package com.example.controllers;

import com.example.models.Chambre;
import com.example.repositories.ChambreRepository;
import com.example.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChambreController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ChambreRepository chambreRepository;
    private static final String uri = "hotels/api";


    @GetMapping(uri + "/hotels/{hotelId}/chambres")
    public List<Chambre> getChambresByHotelId(@PathVariable long hotelId){
        return chambreRepository.findByHotelId(hotelId);
    }

    @GetMapping(uri + "/chambres")
    public List<Chambre> getAllChambres(){
        return chambreRepository.findAll();
    }

    @GetMapping(uri + "/chambres/count")
    public long countChambres(){
        return chambreRepository.count();
    }
}
