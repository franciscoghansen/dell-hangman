package com.franciscohansen.dellhangman.controller;

import com.franciscohansen.dellhangman.model.Game;
import com.franciscohansen.dellhangman.persistence.repositories.GameRepository;
import com.franciscohansen.dellhangman.persistence.services.GameService;
import com.franciscohansen.dellhangman.persistence.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/game")
public class GameController extends AbstractController<Game, GameRepository, GameService> {

    private GameRepository repository;
    private GameService service;
    private WordService wordService;

    @Autowired
    public GameController(GameRepository repository, GameService service, WordService wordService) {
        this.repository = repository;
        this.service = service;
        this.wordService = wordService;
    }

    @Override
    protected GameRepository repository() {
        return repository;
    }

    @Override
    protected GameService service() {
        return service;
    }

    @Override
    protected Game newRecord() {
        return Game.builder()
                .word(wordService.getRandomWord())
                .score(6.0)
                .usedLetters(new ArrayList<>())
                .build();
    }


}
