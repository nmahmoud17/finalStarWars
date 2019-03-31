package com.detroitlabs.finalStarWars.Services;

import com.detroitlabs.finalStarWars.Model.CharacterInfo;
import com.detroitlabs.finalStarWars.Model.MovieInfo;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StarWarsService {


    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();



    public void addHeaders(){
        headers.add("User-Agent","Spring");
        headers.add("Accept",MediaType.APPLICATION_JSON_VALUE);
    }


    public MovieInfo fetchMovieInfo() {
        addHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<MovieInfo> responseEntity = restTemplate.exchange("https://swapi.co/api/films/2",HttpMethod.GET,httpEntity,MovieInfo.class);
        return responseEntity.getBody();
    }

    public CharacterInfo fetchCharacterInfo(String characterURL){
        addHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<CharacterInfo> responseEntity = restTemplate.exchange(characterURL,HttpMethod.GET,httpEntity,CharacterInfo.class);
        return responseEntity.getBody();
    }

}
