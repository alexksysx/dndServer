package me.alexksysx.controller;

import me.alexksysx.model.SubRace;
import me.alexksysx.repo.SubRaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/subrace")
public class SubRaceController {
    @Autowired
    SubRaceRepository subRaceRepository;

    @GetMapping(produces = "application/json")
    public List<SubRace> getAll(){
        return subRaceRepository.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public SubRace create(@RequestBody SubRace subRace) {
        subRaceRepository.save(subRace);
        return subRace;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public SubRace getOne(@PathVariable Long id) {
        return subRaceRepository.getOne(id);
    }
}
