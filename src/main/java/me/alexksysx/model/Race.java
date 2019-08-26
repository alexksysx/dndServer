package me.alexksysx.model;

import java.util.ArrayList;

public class Race {
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

    private ArrayList<String> resists;
    private ArrayList<String> languages;
    private ArrayList<String> skills;
    private ArrayList<Spell> spells;
    private ArrayList<String> features;
    private ArrayList<String> weaponProficiencies;
    private ArrayList<String> armorProficiencies;
}
