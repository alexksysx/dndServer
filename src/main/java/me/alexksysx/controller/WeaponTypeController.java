package me.alexksysx.controller;

import me.alexksysx.model.type.WeaponType;
import me.alexksysx.repo.WeaponTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/weapon-type")
public class WeaponTypeController {

    @Autowired
    WeaponTypeRepository weaponTypeRepository;

    @GetMapping(produces = "application/json")
    public List<WeaponType> list() {
        return weaponTypeRepository.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public WeaponType create(@RequestBody WeaponType weaponType) {
        return weaponTypeRepository.save(weaponType);
    }
}
