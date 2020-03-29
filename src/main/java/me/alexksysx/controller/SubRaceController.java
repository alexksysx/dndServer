package me.alexksysx.controller;

import me.alexksysx.dto.SubRaceDto;
import me.alexksysx.model.Race;
import me.alexksysx.model.SubRace;
import me.alexksysx.repo.RaceRepository;
import me.alexksysx.repo.SubRaceRepository;
import me.alexksysx.service.SubRaceService;
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
    SubRaceService subRaceService;

    @GetMapping(produces = "application/json")
    public List<SubRace> getAll(){
        return subRaceService.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public SubRace create(@RequestBody SubRaceDto subRaceDto) {
        return subRaceService.create(subRaceDto);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public SubRace getOne(@PathVariable Long id) {
        return subRaceService.getOne(id);
    }

}
