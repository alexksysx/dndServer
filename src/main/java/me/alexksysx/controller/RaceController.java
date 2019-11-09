package me.alexksysx.controller;

import me.alexksysx.dto.RaceDto;
import me.alexksysx.model.Race;
import me.alexksysx.model.SubRace;
import me.alexksysx.repo.RaceRepository;
import me.alexksysx.repo.SubRaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/race")
public class RaceController {
    @Autowired
    RaceRepository raceRepository;

    @Autowired
    SubRaceRepository subRaceRepository;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Race createRace(@RequestBody RaceDto raceDto) {
        Race race = raceFromDto(raceDto);
        return raceRepository.save(race);
    }

    @GetMapping(produces = "application/json")
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @GetMapping(produces = "application/json", value = "/{id}")
    public Race getOneRace(@PathVariable Long id) {
        return raceRepository.getOne(id);
    }


    private Race raceFromDto(RaceDto dto) {
        Race race = new Race();
        BeanUtils.copyProperties(dto, race, "subRaces");
        if(dto.getSubRaces() != null && !dto.getSubRaces().isEmpty() ) {
            Set<SubRace> subRaceSet = subRaceRepository.findByIdIn(dto.getSubRaces());
            race.setSubRaces(subRaceSet);
        } else {
            Set<SubRace> subRaceSet = new LinkedHashSet<>();
            race.setSubRaces(subRaceSet);
        }
        return race;
    }
}
