package com.example.controllers;

import com.example.models.Reservation;
import com.example.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    private static final String uri = "hotels/api";


    @GetMapping(uri+"/hotels/{id}/reservations")
    public List<Reservation> getReservationsByHotelId(@PathVariable long id){
        return reservationRepository.findByHotelId(id);
    }

    @GetMapping(uri+"/hotels/{id}/reservations/{idChambre}")
    public List<Reservation> getReservationsByChambreId(@PathVariable long id, @PathVariable long idChambre){
        return reservationRepository.findByChambreId(idChambre);
    }

    @PostMapping(uri+"/hotels/{id}/reservations")
    public Reservation addReservation(@PathVariable long id, @RequestBody Reservation reservation){
        reservation.setHotelId(id);
        return reservationRepository.save(reservation);
    }

}
