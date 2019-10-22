package me.alexksysx.model;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(targetEntity = Race.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "race_id", nullable = false, updatable = false)
    private Race race;
}
