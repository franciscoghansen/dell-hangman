package com.franciscohansen.dellhangman.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import javax.persistence.Lob;
import java.util.List;

@Root
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HangmanXmlDTO {

    @ElementList(name = "word_list")
    private List<String> words;


}
