package me.alexksysx.controller;

import me.alexksysx.model.CommonClass;
import me.alexksysx.model.gameClasses.SpellCaster;
import me.alexksysx.repo.CommonClassRepository;
import me.alexksysx.repo.SpellCasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/class")
public class GameClassController {

    final
    CommonClassRepository commonClassRepository;

    final
    SpellCasterRepository spellCasterRepository;

    public GameClassController(CommonClassRepository commonClassRepository, SpellCasterRepository spellCasterRepository) {
        this.commonClassRepository = commonClassRepository;
        this.spellCasterRepository = spellCasterRepository;
    }

    @GetMapping(produces = "application/json")
    public List<CommonClass> getAll() {
        return new ArrayList<>(commonClassRepository.findAll());
    }

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
