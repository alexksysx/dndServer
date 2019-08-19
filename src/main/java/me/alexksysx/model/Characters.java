package me.alexksysx.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class Characters {
    private AtomicLong counter = new AtomicLong();

    private List<Character> characterList = new ArrayList<>();

    public List<Character> getCharacterList() {
        return characterList;
    }

    public Character getOneById(Long id) {
        return characterList.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }

    public void addCharacter(Character character) {
        character.setId(counter.incrementAndGet());
        characterList.add(character);
    }

}
