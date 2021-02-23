package com.franciscohansen.dellhangman.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

}
