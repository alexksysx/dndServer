package me.alexksysx.dto;

import lombok.Data;

import java.util.List;

@Data
public class WeaponDto {
    private Long id;
    private String name;
    private String source;
    private String description;
    private Double weight;
    private String type;
    private String cost;

    private String damage;
    private List<Long> damageTypes;
    private List<Long> weaponTypes;
}
