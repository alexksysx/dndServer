package me.alexksysx.controller;

import me.alexksysx.dto.LoginDto;
import me.alexksysx.dto.TokenDto;
import me.alexksysx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/token")
public class TokenController {
    @Autowired
    UserService userService;

    @PostMapping
    public TokenDto getToken(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto.getUsername(), loginDto.getPassword());
    }
}
