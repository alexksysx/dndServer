package me.alexksysx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
    private String username;
    private String password;
    private String email;
    private ArrayList<String> roles;
}
