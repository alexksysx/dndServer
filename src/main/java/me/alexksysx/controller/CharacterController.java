package me.alexksysx.controller;

import me.alexksysx.Intermedmodel.InterCharacter;
import me.alexksysx.model.Character;
import me.alexksysx.model.Race;
import me.alexksysx.repo.CharacterRepository;
import me.alexksysx.repo.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    RaceRepository raceRepository;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public Character create(@RequestBody InterCharacter interCharacter) {
        Character character = new Character();
        character.setName(interCharacter.getName());
        Race race = raceRepository.findAllById(interCharacter.getRace());
        character.setRace(race);
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
