package me.alexksysx.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRace {
    @Id
    @GeneratedValue
    @Column(name = "subrace_id")
    private Long id;

    private String name;
    private String description;

    private int strengthBonus;
    private int dexterityBonus;
    private int constitutionBonus;
    private int intelligenceBonus;
    private int wisdomBonus;
    private int charismaBonus;

    @JsonIgnoreProperties("subRaces")
    @ManyToMany(mappedBy = "subRaces", fetch = FetchType.EAGER)
    List<Race> races;
}
