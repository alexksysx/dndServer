package me.alexksysx.controller;

import me.alexksysx.model.gameClass.CommonClass;
import me.alexksysx.repo.CommonClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/class")
public class GameClassController {

    @Autowired
    CommonClassRepository commonClassRepository;

    @GetMapping(produces = "application/json")
    public List<CommonClass> getAll() {
        return new ArrayList<>(commonClassRepository.findAll());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public CommonClass create(@RequestBody CommonClass commonClass) {
        commonClassRepository.save(commonClass);
        return commonClass;
    }
}
