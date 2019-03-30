package com.detroitlabs.finalStarWars.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private String title;
    private String episodeID;
    private ArrayList<String> characters;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("episode_id")
    public String getEpisodeID() {
        return episodeID;
    }

    @JsonProperty("episode_id")
    public void setEpisodeID(String episodeID) {
        this.episodeID = episodeID;
    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }
}
