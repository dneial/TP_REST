package com.example.repositories;

import com.example.models.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
