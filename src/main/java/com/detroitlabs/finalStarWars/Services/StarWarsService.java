package com.detroitlabs.finalStarWars.Services;

import com.detroitlabs.finalStarWars.Model.MovieInfo;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StarWarsService {

    public MovieInfo fetchStarWarsInfo(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Spring");
        headers.add("Accept",MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<MovieInfo> responseEntity = restTemplate.exchange("https://swapi.co/api/films/2", HttpMethod.GET, httpEntity, MovieInfo.class);

        return responseEntity.getBody();
    }

}
