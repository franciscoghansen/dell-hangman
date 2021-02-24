package com.franciscohansen.dellhangman.persistence.services;

import com.franciscohansen.dellhangman.model.Player;
import com.franciscohansen.dellhangman.persistence.repositories.PlayerRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Locale;

@Service
public class PlayerService extends AbstractService<Player, PlayerRepository> {
    private PlayerRepository repository;
    private SecureRandom random;


    @Autowired
    public PlayerService(PlayerRepository repository) {
        this.repository = repository;

    }

    @Override
    protected PlayerRepository repository() {
        return repository;
    }

    public String randomUid() {
        String random;
        do {
            random = RandomStringUtils.randomAlphanumeric(16).toUpperCase(Locale.ROOT);
        } while (this.repository.existsByUid(random));
        return random;
    }
}
