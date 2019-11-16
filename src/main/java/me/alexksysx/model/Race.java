package me.alexksysx.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Proxy(lazy = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Race implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "race_id")
    private Long id;
    private String name;
    private String description;

    private int normalSpeed;
    private int swimSpeed;
    private int climbSpeed;
    private int flySpeed;
    private int darkVision;

//    private Size size;

    private int baseAC;

    private int strengthBonus;
    private int dexterityBonus;
    private int constitutionBonus;
    private int intelligenceBonus;
    private int wisdomBonus;
    private int charismaBonus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties("races")
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = SubRace.class)
    @JoinTable(name = "racesubrace",
            joinColumns = @JoinColumn(name = "subrace_id"),
            inverseJoinColumns = @JoinColumn(name = "race_id"))
    private List<SubRace> subRaces;
    private ArrayList<String> resists;
    private ArrayList<String> languages;
    private ArrayList<String> skills;
    private ArrayList<String> spells;
    private ArrayList<String> features;
    private ArrayList<String> weaponProficiencies;
    private ArrayList<String> armorProficiencies;
}
