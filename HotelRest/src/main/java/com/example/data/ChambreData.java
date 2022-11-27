package com.example.data;

import com.example.models.Chambre;
import com.example.repositories.ChambreRepository;
import com.example.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChambreData {

    @Bean
    public CommandLineRunner initDatabase(ChambreRepository repository){

    }
}
