package com.example.repositories;

import com.example.models.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByHotelId(long hotelId);
}
