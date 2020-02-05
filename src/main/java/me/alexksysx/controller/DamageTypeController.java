package me.alexksysx.controller;

import me.alexksysx.model.type.DamageType;
import me.alexksysx.repo.DamageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/damage-type")
public class DamageTypeController {
    @Autowired
    DamageTypeRepository damageTypeRepository;

    @GetMapping(produces = "application/json")
    public List<DamageType> list() {
        return damageTypeRepository.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public DamageType create(@RequestBody DamageType damageType) {
        return damageTypeRepository.save(damageType);
    }
}
