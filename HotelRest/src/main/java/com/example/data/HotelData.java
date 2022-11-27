package com.example.data;

import com.example.models.Hotel;
import com.example.models.HotelCreator;
import com.example.models.HotelLoader;
import com.example.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class HotelData {

    @Bean
    public CommandLineRunner initDatabase(HotelRepository repository){
        HotelCreator hc = new HotelCreator();
        ArrayList<Hotel> hotels = hc.createHotels();
        return args -> {
            for(Hotel hotel : hotels){
                repository.save(hotel);
            }
        };
    }
}
