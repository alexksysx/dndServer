package me.alexksysx.controller;

import me.alexksysx.model.Size;
import me.alexksysx.repo.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/size")
public class SizeController {

    @Autowired
    SizeRepository sizeRepository;

    @GetMapping(produces = "application/json")
    public List<Size> list() {
        return sizeRepository.findAll();
    }
}
