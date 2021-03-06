package me.alexksysx.model.features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;

@Entity
@Data
@Proxy(lazy = false)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SpellCasterFeature extends Feature {
    private Integer[][] cells;
}
