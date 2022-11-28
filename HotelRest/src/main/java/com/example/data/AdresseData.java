/*
package com.example.data;

import com.example.models.Adresse;
import com.example.models.HotelCreator;
import com.example.repositories.AdresseRepository;
import com.example.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class AdresseData {
    @Bean
    public CommandLineRunner initAdresseDatabase(AdresseRepository repository){
        HotelCreator hc = new HotelCreator();
        ArrayList<Adresse> adresses = hc.createAdresses();
        return args -> {
            repository.saveAll(adresses);
        };
    }
}
*/
