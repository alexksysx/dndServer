package me.alexksysx.controller;

import me.alexksysx.dto.CharacterClassDto;
import me.alexksysx.dto.CharacterDto;
import me.alexksysx.model.Character;
import me.alexksysx.model.bindModel.CharacterClass;
import me.alexksysx.repo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
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
    @Autowired
    CommonClassRepository commonClassRepository;
    @Autowired
    CharacterClassRepository characterClassRepository;

    @Transactional
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('USER')")
    public Character create(@RequestBody CharacterDto characterDto) {
        Character character = characterFromDto(characterDto);
        return characterRepository.save(character);
    }

    @GetMapping(produces = "application/json")
    public List<Character> list(Principal principal) {
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
        BeanUtils.copyProperties(characterDto, character, "race", "subrace", "classes");
        character.setRace(raceRepository.getOne(characterDto.getRace()));
        character.setSubRace(subRaceRepository.getOne(characterDto.getSubRace()));
        List<CharacterClass> classes = new ArrayList<>();
        if (characterDto.getClasses() != null && !characterDto.getClasses().isEmpty()) {
            for (CharacterClassDto charClass : characterDto.getClasses()) {
                CharacterClass characterClass = new CharacterClass();
                BeanUtils.copyProperties(charClass, characterClass, "classes");
                if (charClass.getGameClass() != null) characterClass.setGameClass(commonClassRepository.getOne(charClass.getGameClass()));
                characterClass = characterClassRepository.save(characterClass);
                classes.add(characterClass);
            }
        }
        character.setClasses(classes);
        return character;
    }
}
