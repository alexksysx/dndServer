package me.alexksysx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponDto {
    private Long id;
    private String name;
    private String source;
    private String description;
    private Double weight;
    private String cost;

    private String damageRoll;
    private ArrayList<Long> weaponTypes;
    private ArrayList<Long> damageTypes;
}
