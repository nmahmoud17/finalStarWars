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
        modelAndView.addObject("title", starWarsService.fetchStarWarsInfo().getTitle());

        ArrayList<String> characters = starWarsService.fetchStarWarsInfo().getCharacters();
        for(String character: characters){
            modelAndView.addObject("character",character);
        }

        return modelAndView;
    }

}
