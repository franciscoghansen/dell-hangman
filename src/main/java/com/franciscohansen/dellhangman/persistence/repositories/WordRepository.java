package com.franciscohansen.dellhangman.persistence.repositories;

import com.franciscohansen.dellhangman.model.Word;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RepositoryRestController
@RequestMapping("/word")
public interface WordRepository extends IRepository<Word> {

    @RestResource(exported = false)
    Optional<Word> findByWordEquals(String word);

    boolean existsByWordEquals( String word );

}
