package me.alexksysx.model.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.alexksysx.model.type.DamageType;
import me.alexksysx.model.type.WeaponType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Weapon extends Item implements Serializable {
    private String damage;
    @JsonIgnoreProperties("weapons")
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = WeaponType.class)
    @JoinTable(joinColumns = @JoinColumn(name = "weapontype_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<WeaponType> weaponTypes;
    @JsonIgnoreProperties("weapons")
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = DamageType.class)
    @JoinTable(joinColumns = @JoinColumn(name = "damagetype_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<DamageType> damageTypes;
}
