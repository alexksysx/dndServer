package me.alexksysx.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Entity
@Proxy(lazy = false)
@Table(name = "commonclass")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(columnDefinition = "TYPE", name = "TYPE")
@AllArgsConstructor
@NoArgsConstructor
public class CommonClass {
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
    @Getter @Setter private boolean knowAllSpells;


    @Getter @Setter private ArrayList<Long> abilities = new ArrayList<>();
}
