package com.example.hotelrest;

import com.example.hotelrest.hotel.Hotel;
import com.example.hotelrest.repositories.HotelRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.example.hotelrest.hotel"})
public class HotelRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelRestApplication.class, args);
    }


}
