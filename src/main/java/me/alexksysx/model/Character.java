package me.alexksysx.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Proxy(lazy = false)
public class Character {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String race;
    private String test;

    public Character() {}

    public Character(Long id, String name, String race, String test) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.test = test;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
