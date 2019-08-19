package me.alexksysx.controller;

import me.alexksysx.model.Character;
import me.alexksysx.model.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final Characters characters;

    public CharacterController(Characters characters) {
        this.characters = characters;
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public Character create(@RequestBody Character character) {
        characters.addCharacter(character);
        return character;
    }

    @RequestMapping(produces = "application/json")
    public List<Character> list() {
        return characters.getCharacterList();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Character getOneById(@PathVariable Long id) {
        return characters.getOneById(id);
    }
}
