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
    @OneToOne(targetEntity = Race.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false, updatable = false)
    @Getter @Setter private Race race;
}
