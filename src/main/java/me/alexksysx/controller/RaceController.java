package me.alexksysx.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import me.alexksysx.dto.RaceDto;
import me.alexksysx.model.Race;
import me.alexksysx.model.SubRace;
import me.alexksysx.repo.RaceRepository;
import me.alexksysx.repo.SubRaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@WebEndpoint(id = "race")
@RequestMapping("/race")
public class RaceController {
    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private SubRaceRepository subRaceRepository;

    @Autowired
    private MeterRegistry meterRegistry;

    @Timed(value = "race_aspect")
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

    @PutMapping(produces = "application/json", consumes = "application/json")
    public Race changeRace(@RequestBody RaceDto raceDto) {
        Race race = raceFromDto(raceDto);
        return raceRepository.save(race);
    }

    private Race raceFromDto(RaceDto dto) {
        Race race = new Race();
        BeanUtils.copyProperties(dto, race, "subRaces");
        if(dto.getSubRaces() != null && !dto.getSubRaces().isEmpty() ) {
            List<SubRace> subRaceList = subRaceRepository.findByIdIn(dto.getSubRaces());
            race.setSubRaces(subRaceList);
        } else {
            List<SubRace> subRaceSet = new ArrayList<>();
            race.setSubRaces(subRaceSet);
        }
        return race;
    }
}
