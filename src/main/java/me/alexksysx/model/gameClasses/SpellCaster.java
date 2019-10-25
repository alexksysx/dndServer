package me.alexksysx.model.gameClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.alexksysx.model.CommonClass;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SpellCaster extends CommonClass {
//    @Getter @Setter int[][] spellCells = new int[10][20];
    String inhTest;
}
