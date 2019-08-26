package me.alexksysx.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Entity
@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Getter @Setter private String source;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private String mainCharacteristic;
    @Getter @Setter private String secondCharacteristic;
    @Getter @Setter private String SavingThrow1;
    @Getter @Setter private String SavingThrow2;
    @Getter @Setter private int hitDice;
    @Getter @Setter private boolean spellCasting;
    @Getter @Setter private boolean knowAllSpells;

    @Getter @Setter private int[] cantrip = new int[20];
    @Getter @Setter private int[] level1 = new int[20];
    @Getter @Setter private int[] level2 = new int[20];
    @Getter @Setter private int[] level3 = new int[20];
    @Getter @Setter private int[] level4 = new int[20];
    @Getter @Setter private int[] level5 = new int[20];
    @Getter @Setter private int[] level6 = new int[20];
    @Getter @Setter private int[] level7 = new int[20];
    @Getter @Setter private int[] level8 = new int[20];
    @Getter @Setter private int[] level9 = new int[20];

    @Getter @Setter private ArrayList<Long> abilities = new ArrayList<>();
}
