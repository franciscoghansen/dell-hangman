package com.franciscohansen.dellhangman.persistence.services;

import com.franciscohansen.dellhangman.dto.HangmanXmlDTO;
import com.franciscohansen.dellhangman.model.Word;
import com.franciscohansen.dellhangman.persistence.repositories.WordRepository;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;

@Service
public class WordService extends AbstractService<Word, WordRepository> {

    private WordRepository repository;
    private SecureRandom random;
    @Value("classpath:static/hangman.xml")
    private Resource resource;

    @PostConstruct
    public void init() {
        populate();
    }

    @Autowired
    public WordService(WordRepository repository) {
        this.repository = repository;
        try {
            this.random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public Word getRandomWord() {
        long count = this.repository.count();
        List<Word> list = this.repository.findAll();
        int pos = this.random.nextInt((int) count - 1);
        return list.get(pos);
    }

    @Override
    protected WordRepository repository() {
        return this.repository;
    }

    public void populate() {
        try {
            InputStream is = resource.getInputStream();
            Serializer serializer = new Persister();
            HangmanXmlDTO dto = serializer.read(HangmanXmlDTO.class, is);

            for (String sWord : dto.getWords()) {
                if (!repository.existsByWordEquals(sWord.toUpperCase(Locale.ROOT))) {
                    repository.save(
                            Word.builder()
                                    .word(sWord.toUpperCase(Locale.ROOT))
                                    .build()
                    );
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
