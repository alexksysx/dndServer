package me.alexksysx.model.bindModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.alexksysx.model.features.CounterFeature;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Proxy(lazy = false)
public class CounterFeatureValue {
    @Id @GeneratedValue
    @Column(name = "counter_value")
    private Long id;
    @ManyToOne(targetEntity = CounterFeature.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "feature_id", nullable = false, updatable = false)
    private CounterFeature counterFeature;
    private Integer value;
}
