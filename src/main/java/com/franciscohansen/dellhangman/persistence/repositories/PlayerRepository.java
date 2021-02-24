package com.franciscohansen.dellhangman.persistence.repositories;

import com.franciscohansen.dellhangman.model.Player;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "players", path = "player")
public interface PlayerRepository extends IRepository<Player> {

    Player findByNameEquals(@Param("name") String name);

    boolean existsByUid(@Param("uid") String uid);

    Player findByUid(@Param("uid") String uid);
}
