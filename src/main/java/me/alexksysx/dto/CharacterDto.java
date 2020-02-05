package me.alexksysx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.alexksysx.model.bindModel.CharacterClass;
import me.alexksysx.model.gameClass.CommonClass;

import java.util.ArrayList;
import java.util.List;

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
