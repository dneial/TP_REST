package com.example.data;

import com.example.models.Adresse;
import com.example.models.Hotel;
import com.example.models.HotelCreator;
import com.example.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class HotelData {

    @Bean
    public CommandLineRunner initHotelDatabase(HotelRepository repository){
        Adresse a1 = new Adresse(0, "France", "Paris", "Rue des Papillons", 1, "75001");
        return args -> {
            repository.save(new Hotel(0,"Hotel de la Paix", a1, 5));
        };
    }
}
