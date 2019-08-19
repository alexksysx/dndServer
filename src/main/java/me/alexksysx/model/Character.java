package me.alexksysx.model;

public class Character {
    private Long id;
    private String name;
    private String race;

    private Character() {}

    public Character(Long id, String name, String race) {
        this.id = id;
        this.name = name;
        this.race = race;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                '}';
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
}
