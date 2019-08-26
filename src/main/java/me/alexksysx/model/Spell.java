package me.alexksysx.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Proxy(lazy = false)
public class Spell {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Getter @Setter private int level;
    @Getter @Setter private String type;
    @Getter @Setter private String description;
}
