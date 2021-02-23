package com.franciscohansen.dellhangman;

import com.franciscohansen.dellhangman.dto.HangmanXmlDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class DellHangmanApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void xmlDeserialization(@Value("classpath:static/hangman.xml") Resource resource) {
        try {
            File file = resource.getFile();
            Serializer serializer = new Persister();
            HangmanXmlDTO dto = serializer.read(HangmanXmlDTO.class, file);
            Assertions.assertEquals(15, dto.getWords().size());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }

    }

}
