package me.alexksysx.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SubRaceDto {
    private Long id;
    private String name;
    private String description;
    private int strengthBonus;
    private int dexterityBonus;
    private int constitutionBonus;
    private int intelligenceBonus;
    private int wisdomBonus;
    private int charismaBonus;
    private ArrayList<Long> races;
}
