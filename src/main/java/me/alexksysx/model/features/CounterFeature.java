package me.alexksysx.model.features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Proxy(lazy = false)
@EqualsAndHashCode(callSuper = true)
@Table(name = "counter_feature")
@AllArgsConstructor
@NoArgsConstructor
public class CounterFeature extends Feature {
    private int[] amount;
}
