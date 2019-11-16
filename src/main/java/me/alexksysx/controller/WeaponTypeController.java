package me.alexksysx.controller;

import me.alexksysx.model.WeaponType;
import me.alexksysx.repo.WeaponTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
