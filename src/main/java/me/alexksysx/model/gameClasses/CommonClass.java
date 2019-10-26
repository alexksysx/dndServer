package me.alexksysx.model.gameClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
@Table(name = "commonclass")
@Inheritance
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonClass {
    @Id
    @GeneratedValue
    private Long id;
    private String source;
    private String name;
    private String description;
    private String mainCharacteristic;
    private String secondCharacteristic;
    private String SavingThrow1;
    private String SavingThrow2;
    private int hitDice;
    private boolean knowAllSpells;


//    private ArrayList<Long> abilities = new ArrayList<>();
}
