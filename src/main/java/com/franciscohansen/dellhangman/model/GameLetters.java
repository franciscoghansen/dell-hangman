package com.franciscohansen.dellhangman.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GameLetters extends AbstractModel {

    @Column
    private String letter;
}
