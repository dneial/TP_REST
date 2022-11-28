package com.example.hotelrest.data;

import com.example.hotelrest.HotelRestApplication;
import com.example.hotelrest.hotel.Hotel;
import com.example.hotelrest.hotel.HotelLoader;
import com.example.hotelrest.repositories.HotelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class HotelData {
    private ArrayList<Hotel> hotels = HotelLoader.loadFromFiles();

    @Bean
    public void initDataBase(HotelRepository repository){
        for(Hotel h: hotels){
            repository.save(h);
        }
    }
}
