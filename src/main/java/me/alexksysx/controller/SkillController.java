package me.alexksysx.controller;

import me.alexksysx.model.Skill;
import me.alexksysx.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    SkillRepository skillRepository;

    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public Skill create(@RequestBody Skill skill) {
        skillRepository.save(skill);
        return skill;
    }

    @RequestMapping
    public List<Skill> list() {
        List<Skill> list = skillRepository.findAll();
        return list;
    }
}
