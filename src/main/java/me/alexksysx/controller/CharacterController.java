package me.alexksysx.controller;

import me.alexksysx.model.Character;
import me.alexksysx.repo.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public Character create(@RequestBody Character character) {
        characterRepository.save(character);
        return character;
    }

    @RequestMapping(produces = "application/json")
    public List<Character> list() {
        return characterRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Character getOneById(@PathVariable Long id) {
        return characterRepository.getOne(id);
    }
}
