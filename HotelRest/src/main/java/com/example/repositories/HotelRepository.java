package com.example.repositories;

import com.example.models.Adresse;
import com.example.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    //List<Hotel> findByGreaterThanEqualNbEtoileAndAdresseVille(int nbEtoi, String ville);
}

