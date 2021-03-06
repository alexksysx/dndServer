package me.alexksysx.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.alexksysx.model.bindModel.CharacterClass;
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
public class Character implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Integer level;
    private String name;
    @ManyToOne(targetEntity = Race.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "race_id", nullable = false, updatable = false)
    @JsonIgnoreProperties("subRaces")
    private Race race;
    @ManyToOne(targetEntity = SubRace.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "subrace_id", nullable = false, updatable = false)
    @JsonIgnoreProperties("races")
    private SubRace subRace;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CharacterClass> classes;
}
