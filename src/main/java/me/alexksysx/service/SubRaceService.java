package me.alexksysx.service;

import me.alexksysx.dto.SubRaceDto;
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
public class SubRaceService {
    @Autowired
    SubRaceRepository subRaceRepository;

    @Autowired
    RaceRepository raceRepository;

    public List<SubRace> findAll() {
        return subRaceRepository.findAll();
    }

    public SubRace getOne(Long id) {
        return subRaceRepository.getOne(id);
    }

    public SubRace create(SubRaceDto subRaceDto) {
        SubRace subRace = getSubRaceFromDto(subRaceDto);
        Race race = raceRepository.getOne(subRaceDto.getRaces().get(0));
        SubRace newSubRace = subRaceRepository.save(subRace);
        race.addSubRace(newSubRace);
        raceRepository.save(race);
        return subRaceRepository.getOne(newSubRace.getId());
    }

    private SubRace getSubRaceFromDto(SubRaceDto subRaceDto) {
        SubRace subRace = new SubRace();
        BeanUtils.copyProperties(subRaceDto, subRace, "races");
        subRace.setRaces(new ArrayList<>());
        return subRace;
    }

}
