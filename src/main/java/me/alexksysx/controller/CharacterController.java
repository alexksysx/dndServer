package me.alexksysx.controller;


import me.alexksysx.exceptions.NotFoundException;
import me.alexksysx.model.Character;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final AtomicLong counter = new AtomicLong();
    private List<Character> characters = new ArrayList<>();

    @RequestMapping("/create")
    public Character create (@RequestParam(value = "name", defaultValue = "CharacterName") String name,
                         @RequestParam(value = "race", defaultValue = "Human") String race,
                         @RequestParam(value = "subrace", defaultValue = "Common") String subrace,
                         @RequestParam(value = "gameClass", defaultValue = "Barbarian") String gameClass,
                         @RequestParam(value = "strength", defaultValue = "10") short strength,
                         @RequestParam(value = "dexterity", defaultValue = "10") short dexterity,
                         @RequestParam(value = "constitution", defaultValue = "10") short constitution,
                         @RequestParam(value = "intelligence", defaultValue = "10") short intelligence,
                         @RequestParam(value = "wisdom", defaultValue = "10") short wisdom,
                         @RequestParam(value = "charisma", defaultValue = "10") short charisma) {
        Long cnt = counter.incrementAndGet();
        Character character = new Character(cnt, name, race, subrace,
                gameClass, strength, dexterity, constitution, intelligence, wisdom, charisma);
        characters.add(character);
        return character;
    }

    @GetMapping()
    public List<Character> list() {
        return characters;
    }

    @GetMapping("/{id}")
    public Character getOne(@PathVariable Long id) {
        return characters.stream()
                .filter(p -> p.getId()==id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

}
