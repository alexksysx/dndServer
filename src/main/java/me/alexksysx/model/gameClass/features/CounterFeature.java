package me.alexksysx.model.gameClass.features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
public class CounterFeature {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int requiredLevel;
    private int[] amount;
    private String description;
}
