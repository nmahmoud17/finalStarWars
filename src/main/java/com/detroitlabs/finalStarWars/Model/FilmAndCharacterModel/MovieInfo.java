package com.detroitlabs.finalStarWars.Model.FilmAndCharacterModel;

import com.detroitlabs.finalStarWars.Model.FilmAndCharacterModel.Characters;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieInfo {

    private String title;
    private Characters characters;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }
}
