package me.alexksysx.controller;

import me.alexksysx.model.Race;
import me.alexksysx.repo.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/race")
public class RaceController {
    @Autowired
    RaceRepository raceRepository;

    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public Race createRace(@RequestBody Race race) {
        raceRepository.save(race);
        return race;
    }

    @GetMapping(produces = "application/json")
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }
}
