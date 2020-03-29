package me.alexksysx.model.gameClass.features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.alexksysx.model.gameClass.ClassFeature;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;

@Entity
@Data
@Proxy(lazy = false)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class AdjustmentFeature extends ClassFeature {
    private String formula;
}
