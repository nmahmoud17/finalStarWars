package com.detroitlabs.finalStarWars.Controller;

import com.detroitlabs.finalStarWars.Services.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SwapiController {

    @Autowired
    StarWarsService starWarsService;

    @RequestMapping("/")
    public ModelAndView showMovieCharacters(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("title", starWarsService.fetchMovieInfo().getTitle());

        ArrayList<String> characterURLS = starWarsService.fetchMovieInfo().getCharacters();
        ArrayList<String> names = new ArrayList<>();
        for(String url: characterURLS) {
            names.add(starWarsService.fetchCharacterInfo(url).getName());
        }
        modelAndView.addObject("names",names);
        return modelAndView;
    }


}
