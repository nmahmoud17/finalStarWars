package com.detroitlabs.finalStarWars.Controller;

import com.detroitlabs.finalStarWars.Model.FilmAndCharacterModel.CharacterInfo;
import com.detroitlabs.finalStarWars.Model.SearchModel.CharacterDetail;
import com.detroitlabs.finalStarWars.Services.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SwapiController {

    @Autowired
    private StarWarsService starWarsService;

    @RequestMapping("/")
    public ModelAndView showMovieInfoAndCharacters(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("title", starWarsService.fetchMovieInfo().getTitle());

        ArrayList<String> characterURLS = starWarsService.fetchMovieInfo().getCharacters();
        ArrayList<CharacterInfo> characters = new ArrayList<>();

        for(String url: characterURLS) {
            characters.add(starWarsService.fetchCharacterInfo(url));
        }

        modelAndView.addObject("characters",characters);
        modelAndView.addObject("opening",starWarsService.fetchOpeningCrawl());

        return modelAndView;
    }

//    @RequestMapping("/details")
//    public ModelAndView showCharacterDetails(@RequestParam("characterName") String characterName) {
//        ModelAndView modelAndView = new ModelAndView("detailsPage");
//
//
//        CharacterDetail characterDetail = starWarsService.fetchCharacterInfoByName(characterName).getResults().get(0);
//
//        modelAndView.addObject("name",characterDetail.getName());
//        modelAndView.addObject("birthYear",characterDetail.getBirthYear());
//        modelAndView.addObject("gender",characterDetail.getGender());
//
//        String planetUrl = characterDetail.getHomeworld();
//
//        String planetName = starWarsService.fetchPlanetInfo(planetUrl).getName();
//
//        modelAndView.addObject("planet",planetName);
//
//        return modelAndView;
//
//    }

    @RequestMapping("/details/{characterName}")
    public String showCharacterDetails(@PathVariable String characterName,ModelMap modelMap){
        CharacterDetail characterDetail = starWarsService.fetchCharacterInfoByName(characterName).getResults().get(0);

        modelMap.put("name",characterDetail.getName());
        modelMap.put("birthYear",characterDetail.getBirthYear());
        modelMap.put("gender",characterDetail.getGender());

        String planetUrl = characterDetail.getHomeworld();

        String planetName = starWarsService.fetchPlanetInfo(planetUrl).getName();

        modelMap.put("planet",planetName);
        return "detailsPage";

    }


}
