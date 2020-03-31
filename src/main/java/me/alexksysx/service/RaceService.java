package me.alexksysx.service;

import me.alexksysx.dto.RaceDto;
import me.alexksysx.model.Race;
import me.alexksysx.model.SubRace;
import me.alexksysx.repo.RaceRepository;
import me.alexksysx.repo.SubRaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceService {
    @Autowired
    RaceRepository raceRepository;

    @Autowired
    SubRaceRepository subRaceRepository;

    public Race createRace(RaceDto raceDto) {
        Race race = raceFromDto(raceDto);
        return raceRepository.save(race);
    }

    public Race changeRace(RaceDto raceDto) {
        Race race = raceFromDto(raceDto);
        return raceRepository.save(race);
    }

    public Race getOne(Long id) {
        return raceRepository.getOne(id);
    }

    public List<Race> findAll() {
        return raceRepository.findAll();
    }

    private Race raceFromDto(RaceDto dto) {
        Race race = new Race();
        BeanUtils.copyProperties(dto, race, "subRaces");
        if (dto.getSubRaces() != null && !dto.getSubRaces().isEmpty()) {
            List<SubRace> subRaceList = subRaceRepository.findByIdIn(dto.getSubRaces());
            race.setSubRaces(subRaceList);
        } else {
            List<SubRace> subRaceSet = new ArrayList<>();
            race.setSubRaces(subRaceSet);
        }
        return race;
    }
}
