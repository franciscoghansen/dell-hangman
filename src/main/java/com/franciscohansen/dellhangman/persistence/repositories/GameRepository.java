package com.franciscohansen.dellhangman.persistence.repositories;

import com.franciscohansen.dellhangman.model.Game;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/game")
public interface GameRepository extends IRepository<Game> {
}
