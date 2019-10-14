package me.alexksysx.controller;

import me.alexksysx.model.CommonClass;
import me.alexksysx.model.gameClasses.SpellCaster;
import me.alexksysx.repo.CommonClassRepository;
import me.alexksysx.repo.SpellCasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/class")
public class GameClassController {
    @Autowired
    CommonClassRepository commonClassRepository;

    @Autowired
    SpellCasterRepository spellCasterRepository;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public CommonClass create(@RequestBody CommonClass commonClass) {
        commonClassRepository.save(commonClass);
        return commonClass;
    }

    @PostMapping(value = "/create/spellcaster", produces = "application/json", consumes = "application/json")
    public SpellCaster createSpellCaster(@RequestBody SpellCaster spellCaster) {
        spellCasterRepository.save(spellCaster);
        return spellCaster;
    }
}
