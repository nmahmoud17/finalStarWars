package com.detroitlabs.finalStarWars.Model.FilmAndCharacterModel;

import com.detroitlabs.finalStarWars.Model.FilmAndCharacterModel.Characters;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieInfo {

    private String title;
    private Characters characters;
    private String openingCrawl;

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

    @JsonProperty("opening_crawl")
    public String getOpeningCrawl() {
        return openingCrawl;
    }
    @JsonProperty("opening_crawl")
    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }
}
