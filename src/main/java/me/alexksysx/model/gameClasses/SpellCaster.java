package me.alexksysx.model.gameClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.alexksysx.model.CommonClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SpellCaster extends CommonClass {
//    @Getter @Setter int[][] spellCells = new int[10][20];
    @Getter @Setter String inhTest;
}
