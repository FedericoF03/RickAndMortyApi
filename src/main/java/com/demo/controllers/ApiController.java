package com.demo.controllers;

import com.demo.model.ApiRoutes;
import com.demo.model.Character;
import com.demo.model.RouteCharacters;
import com.demo.templates.FefeClient;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RequestMapping("/api/rickAndMorty")
public class ApiController {

    private final String UrlBaseRickAndMorty = "https://rickandmortyapi.com";

    @GetMapping("/getAllCharacters")
    public RouteCharacters getApi() {
        String stringCharacterRoute = new FefeClient<ApiRoutes>(UrlBaseRickAndMorty) {
        }.getRequest("/api").getCharacters().replace("https://rickandmortyapi.com", "");
        return new FefeClient<RouteCharacters>(UrlBaseRickAndMorty) {
        }.getRequest(stringCharacterRoute);
    }

    @GetMapping("/character/{id}")
    public Character getCharacter(@PathVariable Long id) {
        return new FefeClient<Character>(UrlBaseRickAndMorty) {
        }.getRequest("/api/character/%s".formatted(id));
    }
}
