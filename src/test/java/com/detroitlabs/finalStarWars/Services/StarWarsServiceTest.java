package com.detroitlabs.finalStarWars.Services;

import com.detroitlabs.finalStarWars.Model.MovieInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class StarWarsServiceTest {

    @Test
    public void shouldReturnTitle() {
        StarWarsService starWarsService = new StarWarsService();
        Assert.assertEquals("The Empire Strikes Back", starWarsService.fetchStarWarsInfo().getCharacters());
    }

    @Test
    public void shouldReturn200ResponseCode(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("User-Agent", "Spring" );
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<MovieInfo> response = restTemplate.exchange("https://swapi.co/api/films/2",
                HttpMethod.GET, httpEntity, MovieInfo.class);

        Assert.assertEquals(200, response.getStatusCodeValue());
    }
}