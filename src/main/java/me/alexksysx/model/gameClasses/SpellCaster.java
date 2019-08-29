package me.alexksysx.model.gameClasses;

import lombok.Getter;
import lombok.Setter;
import me.alexksysx.model.CommonClass;

public class SpellCaster extends CommonClass {
    @Getter @Setter int[][] spellCells = new int[10][20];
}
