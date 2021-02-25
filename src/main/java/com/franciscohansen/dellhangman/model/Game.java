package com.franciscohansen.dellhangman.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Game extends AbstractModel {

    @ManyToOne(optional = false)
    @JoinColumn(name = "word_id", referencedColumnName = "id")
    private Word word;
    @ManyToOne(optional = false)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;
    @Column
    private double score = 6;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn( name = "game_id", referencedColumnName = "id")
    private List<GameLetters> usedLetters;

}
