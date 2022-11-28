package com.example.data;

import com.example.models.Chambre;
import com.example.repositories.ChambreRepository;
import com.example.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ChambreData {
    @Bean
    public CommandLineRunner initChambreDatabase(ChambreRepository repository){
        List<List<Chambre>> list_of_chambres = new ArrayList<>();
        for(int i=0; i<16; i++){
            List<Chambre> lc = new ArrayList<>();
            int cc = i;
            lc.add(new Chambre(i+cc++, 2, cc, i));
            lc.add(new Chambre(i+cc++, 2, cc, i));
            lc.add(new Chambre(i+cc++, 3, cc, i));
            lc.add(new Chambre(i+cc++, 3, cc, i));
            lc.add(new Chambre(i+cc++, 4, cc, i));
            lc.add(new Chambre(i+cc++, 4, cc, i));
            list_of_chambres.add(lc);
        }
        return args -> {
            for(List<Chambre> lc : list_of_chambres){
                repository.saveAll(lc);
            }
        };
    }
}
