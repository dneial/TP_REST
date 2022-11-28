/*
package com.example.controllers;

import com.example.models.Reservation;
import com.example.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
*/
