package me.alexksysx.model.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.alexksysx.model.item.Weapon;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
@Proxy(lazy = false)
@NoArgsConstructor
@AllArgsConstructor
public class WeaponType {
    @Id
    @GeneratedValue
    @Column(name = "weapontype_id")
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @JsonIgnoreProperties("weaponTypes")
    @ManyToMany(mappedBy = "weaponTypes", fetch = FetchType.EAGER)
    List<Weapon> weapons = new ArrayList<>();
}
