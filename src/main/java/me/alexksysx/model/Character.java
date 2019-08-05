package me.alexksysx.model;

public class Character {
    private long id;
    private String name;
    private String race;
    private String subrace;
    private String gameClass;
    private short strength, dexterity, constitution, intelligence, wisdom, charisma;

    public Character(long id, String name, String race, String subrace, String gameClass, short strength, short dexterity, short constitution, short intelligence, short wisdom, short charisma) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.subrace = subrace;
        this.gameClass = gameClass;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSubrace() {
        return subrace;
    }

    public void setSubrace(String subrace) {
        this.subrace = subrace;
    }

    public String getGameClass() {
        return gameClass;
    }

    public void setGameClass(String gameClass) {
        this.gameClass = gameClass;
    }

    public short getStrength() {
        return strength;
    }

    public void setStrength(short strength) {
        this.strength = strength;
    }

    public short getDexterity() {
        return dexterity;
    }

    public void setDexterity(short dexterity) {
        this.dexterity = dexterity;
    }

    public short getConstitution() {
        return constitution;
    }

    public void setConstitution(short constitution) {
        this.constitution = constitution;
    }

    public short getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(short intelligence) {
        this.intelligence = intelligence;
    }

    public short getWisdom() {
        return wisdom;
    }

    public void setWisdom(short wisdom) {
        this.wisdom = wisdom;
    }

    public short getCharisma() {
        return charisma;
    }

    public void setCharisma(short charisma) {
        this.charisma = charisma;
    }
}
