package me.alexksysx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaceDto implements Serializable {
    private Long id;
    private String name;
    private String description;

    private int normalSpeed;
    private int swimSpeed;
    private int climbSpeed;
    private int flySpeed;
    private int darkVision;

    private int baseAC;

    private int strengthBonus;
    private int dexterityBonus;
    private int constitutionBonus;
    private int intelligenceBonus;
    private int wisdomBonus;
    private int charismaBonus;

    private ArrayList<Long> subRaces;
}
