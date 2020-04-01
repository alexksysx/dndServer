package me.alexksysx.model.bindModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.alexksysx.model.features.Feature;
import me.alexksysx.model.features.OptionsFeature;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Proxy(lazy = false)
public class FeatureChoice {
    @Id @GeneratedValue
    @Column(name = "choice_id")
    private Long id;
    @ManyToOne(targetEntity = OptionsFeature.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "option_id", nullable = false, updatable = false)
    private OptionsFeature optionFeature;
    @ManyToOne(targetEntity = Feature.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "feature_id",nullable = false, updatable = false)
    private Feature pickedFeature;
}
