package com.franciscohansen.dellhangman.persistence.repositories;

import com.franciscohansen.dellhangman.model.Player;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/player")
public interface PlayerRepository extends IRepository<Player> {
}
