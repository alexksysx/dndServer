package me.alexksysx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionFeatureDto {
    private String name;
    private Integer requiredLevel;
    private String description;
    private ArrayList<Long> options;
}
