package me.alexksysx.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Proxy(lazy = false)
public class Ability {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private String restoration;
    @Getter @Setter private int counter;
}
