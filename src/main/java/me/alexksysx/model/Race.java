package me.alexksysx.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
public class Race {
    @Id
    @GeneratedValue
    @Getter @Setter
    @Column(name = "race_id")

    private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;

    @Getter @Setter private int normalSpeed;
    @Getter @Setter private int swimSpeed;
    @Getter @Setter private int climbSpeed;
    @Getter @Setter private int flySpeed;
    @Getter @Setter private int darkVision;

    @Getter @Setter private int baseAC;

    @Getter @Setter private int strengthBonus;
    @Getter @Setter private int dexterityBonus;
    @Getter @Setter private int constitutionBonus;
    @Getter @Setter private int intelligenceBonus;
    @Getter @Setter private int wisdomBonus;
    @Getter @Setter private int charismaBonus;

    @Getter @Setter private ArrayList<String> resists;
    @Getter @Setter private ArrayList<String> languages;
    @Getter @Setter private ArrayList<String> skills;
    @Getter @Setter private ArrayList<String> spells;
    @Getter @Setter private ArrayList<String> features;
    @Getter @Setter private ArrayList<String> weaponProficiencies;
    @Getter @Setter private ArrayList<String> armorProficiencies;
}
