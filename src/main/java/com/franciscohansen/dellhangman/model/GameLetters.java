package com.franciscohansen.dellhangman.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GameLetters extends AbstractModel {

    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;
    @Column
    private String letter;
}
