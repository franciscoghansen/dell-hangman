package com.franciscohansen.dellhangman.persistence.services;

import com.franciscohansen.dellhangman.model.Game;
import com.franciscohansen.dellhangman.persistence.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService extends AbstractService<Game, GameRepository> {
    private GameRepository repository;

    @Autowired
    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GameRepository repository() {
        return repository;
    }
}
