package com.detroitlabs.finalStarWars.Controller;

import com.detroitlabs.finalStarWars.Model.FilmAndCharacterModel.CharacterInfo;
import com.detroitlabs.finalStarWars.Model.SearchModel.CharacterDetail;
import com.detroitlabs.finalStarWars.Services.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SwapiController {

    @Autowired
    private StarWarsService starWarsService;

    @RequestMapping("/")
    public ModelAndView showMovieCharacters(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("title", starWarsService.fetchMovieInfo().getTitle());

        ArrayList<String> characterURLS = starWarsService.fetchMovieInfo().getCharacters();
        ArrayList<CharacterInfo> characters = new ArrayList<>();

        for(String url: characterURLS) {
            characters.add(starWarsService.fetchCharacterInfo(url));
        }

        modelAndView.addObject("characters",characters);

        return modelAndView;
    }

    @RequestMapping("/details")
    public ModelAndView showCharacterDetails(@RequestParam("characterName") String characterName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("detailsPage");

        CharacterDetail characterDetail = starWarsService.fetchInfoByName(characterName).getResults().get(0);

        modelAndView.addObject("name",characterDetail.getName());
        modelAndView.addObject("birthYear",characterDetail.getBirthYear());
        modelAndView.addObject("gender",characterDetail.getGender());

        String planetUrl = characterDetail.getHomeworld();

        String planetName = starWarsService.fetchPlanetInfo(planetUrl).getName();

        modelAndView.addObject("planet",planetName);

        return modelAndView;

    }


}
