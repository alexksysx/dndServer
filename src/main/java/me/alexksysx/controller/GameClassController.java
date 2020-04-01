package me.alexksysx.controller;

import me.alexksysx.model.gameClass.GameClass;
import me.alexksysx.repo.GameClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/class")
public class GameClassController {

    @Autowired
    GameClassRepository gameClassRepository;

    @GetMapping(produces = "application/json")
    public List<GameClass> getAll() {
        return new ArrayList<>(gameClassRepository.findAll());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public GameClass create(@RequestBody GameClass gameClass) {
        gameClassRepository.save(gameClass);
        return gameClass;
    }
}
