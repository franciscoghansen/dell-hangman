package com.franciscohansen.dellhangman.controller;

import com.franciscohansen.dellhangman.model.Word;
import com.franciscohansen.dellhangman.persistence.repositories.WordRepository;
import com.franciscohansen.dellhangman.persistence.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/word")
public class WordController extends AbstractController<Word, WordRepository, WordService> {

    private WordRepository repository;
    private WordService service;

    @Autowired
    public WordController(WordRepository repository, WordService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    WordRepository repository() {
        return repository;
    }

    @Override
    WordService service() {
        return service;
    }

    @GetMapping("/random-word")
    public Word getRandomWord(){
        return this.service.getRandomWord();
    }
}
