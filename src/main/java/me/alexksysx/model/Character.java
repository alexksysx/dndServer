package me.alexksysx.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    @Id
    @GeneratedValue
    private Long id;
    @Getter @Setter private String name;
    @ManyToOne(targetEntity = Race.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @Getter @Setter private Race race;
}
