package com.detroitlabs.finalStarWars.Services;

import com.detroitlabs.finalStarWars.Model.AllStarWarsData;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StarWarsService {

    public AllStarWarsData fetchStarWarsInfo(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://swapi.co/api/films/", AllStarWarsData.class);
    }
}
