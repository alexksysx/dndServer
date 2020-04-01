package me.alexksysx.controller;

import me.alexksysx.dto.CharacterDto;
import me.alexksysx.model.Character;
import me.alexksysx.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @Transactional
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('USER')")
    public Character create(@RequestBody CharacterDto characterDto) {
        return characterService.create(characterDto);
    }

    @GetMapping(produces = "application/json")
    public List<Character> list(Principal principal) {
        return characterService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Character getOneById(@PathVariable Long id) {
        return characterService.getOne(id);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity remove(@PathVariable Long id) {
        if (characterService.existsById(id)) {
            characterService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
