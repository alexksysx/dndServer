package me.alexksysx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {
    private Long id;
    private String name;
    private Long race;
    private Long subRace;
    private Integer level;
    private ArrayList<CharacterClassDto> classes;
}
