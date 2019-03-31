package com.detroitlabs.finalStarWars.Services;

import com.detroitlabs.finalStarWars.Model.FilmAndCharacterModel.MovieInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class StarWarsServiceTest {

    private StarWarsService testStarWarsService;

    @Before
    public void create(){
        testStarWarsService = new StarWarsService();
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

    @Test
    public void shouldReturnTitleOfMovie(){
        String title = testStarWarsService.fetchMovieInfo().getTitle();
        Assert.assertEquals("The Empire Strikes Back", title);
        Assert.assertNotNull(title);
    }

    @Test
    public void shouldReturnDetailsBasedOnSearch(){
        String name = testStarWarsService.fetchInfoByName("Luke").getResults().get(0).getName();
        Assert.assertEquals("Luke Skywalker", name);

    }



}