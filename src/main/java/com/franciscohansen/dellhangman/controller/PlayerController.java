package com.franciscohansen.dellhangman.controller;

import com.franciscohansen.dellhangman.model.Player;
import com.franciscohansen.dellhangman.persistence.repositories.PlayerRepository;
import com.franciscohansen.dellhangman.persistence.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController extends AbstractController<Player, PlayerRepository, PlayerService> {

    private PlayerRepository repository;
    private PlayerService service;

    @Autowired
    public PlayerController(PlayerRepository repository, PlayerService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    protected PlayerRepository repository() {
        return repository;
    }

    @Override
    protected PlayerService service() {
        return service;
    }

    @Override
    protected Player newRecord() {
        return Player.builder()
                .uid(this.service.randomUid())
                .build();
    }
}
