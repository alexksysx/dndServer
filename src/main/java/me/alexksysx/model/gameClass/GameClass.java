package me.alexksysx.model.gameClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
@Table(name = "gameclass")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameClass {
    @Id
    @GeneratedValue
    @Column(name = "gameclass_id")
    private Long id;
    private String source;
    private String name;
    private String description;
    private String mainCharacteristic;
    private String SavingThrow1;
    private String SavingThrow2;
    private int hitDice;
    private String healthModifierFormula;
    private boolean knowAllSpells;
}