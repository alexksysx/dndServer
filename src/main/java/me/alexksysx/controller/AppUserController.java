package me.alexksysx.controller;

import me.alexksysx.dto.AppUserDto;
import me.alexksysx.model.AppUser;
import me.alexksysx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class AppUserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public AppUser getUserDetails(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public AppUser createUser(@RequestBody AppUserDto appUserDto) {
        return userService.createNewUser(appUserDto);
    }
}
