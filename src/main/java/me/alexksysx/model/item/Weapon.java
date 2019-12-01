package me.alexksysx.model.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.alexksysx.model.type.DamageType;
import me.alexksysx.model.type.WeaponType;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Weapon extends Item implements Serializable {
    private String damage;
    private List<DamageType> damageTypes;
    private List<WeaponType> weaponTypes;
}
