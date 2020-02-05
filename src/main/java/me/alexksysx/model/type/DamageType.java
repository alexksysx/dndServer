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
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
public class DamageType {
    @Id
    @GeneratedValue
    @Column(name = "damagetype_id")
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @JsonIgnoreProperties("damageTypes")
    @ManyToMany(mappedBy = "damageTypes", fetch = FetchType.EAGER)
    List<Weapon> weapons = new ArrayList<>();
}
