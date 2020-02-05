package me.alexksysx.model.gameClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SpellCaster extends CommonClass {
//    int[][] spellCells = new int[10][20];
    String inhTest;
}
