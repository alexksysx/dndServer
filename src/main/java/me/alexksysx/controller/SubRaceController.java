package me.alexksysx.controller;

import me.alexksysx.dto.SubRaceDto;
import me.alexksysx.model.Race;
import me.alexksysx.model.SubRace;
import me.alexksysx.repo.RaceRepository;
import me.alexksysx.repo.SubRaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/subrace")
public class SubRaceController {
    @Autowired
    SubRaceRepository subRaceRepository;

    @Autowired
    RaceRepository raceRepository;

    @GetMapping(produces = "application/json")
    public List<SubRace> getAll(){
        return subRaceRepository.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public SubRace create(@RequestBody SubRaceDto subRaceDto) {
        SubRace subRace = getSubRaceFromDto(subRaceDto);
        Race race = raceRepository.getOne(subRaceDto.getRaces().get(0));
        SubRace newSubRace = subRaceRepository.save(subRace);
        race.addSubRace(newSubRace);
        raceRepository.save(race);
        return subRaceRepository.getOne(newSubRace.getId());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public SubRace getOne(@PathVariable Long id) {
        return subRaceRepository.getOne(id);
    }

    private SubRace getSubRaceFromDto(SubRaceDto subRaceDto) {
        SubRace subRace = new SubRace();
        BeanUtils.copyProperties(subRaceDto, subRace, "races");
        subRace.setRaces(new ArrayList<>());
        return subRace;
    }
}
