package me.alexksysx.controller;

import me.alexksysx.dto.CharacterDto;
import me.alexksysx.model.Character;
import me.alexksysx.repo.CharacterRepository;
import me.alexksysx.repo.RaceRepository;
import me.alexksysx.repo.SubRaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    RaceRepository raceRepository;
    @Autowired
    SubRaceRepository subRaceRepository;

    @Transactional
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Character create(@RequestBody CharacterDto characterDto) {
        Character character = characterFromDto(characterDto);
        return characterRepository.save(character);
    }

    @GetMapping(produces = "application/json")
    public List<Character> list() {
        return characterRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Character getOneById(@PathVariable Long id) {
        return characterRepository.getOne(id);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity remove(@PathVariable Long id) {
        if (characterRepository.existsById(id)) {
            characterRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private Character characterFromDto(CharacterDto characterDto) {
        Character character = new Character();
        BeanUtils.copyProperties(characterDto, character, "race", "subrace");
        character.setRace(raceRepository.getOne(characterDto.getRace()));
        character.setSubRace(subRaceRepository.getOne(characterDto.getSubRace()));
        return character;
    }
}
