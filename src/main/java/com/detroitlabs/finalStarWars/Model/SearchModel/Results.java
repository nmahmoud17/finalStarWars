package com.detroitlabs.finalStarWars.Model.SearchModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results extends ArrayList<CharacterDetail> {
}
