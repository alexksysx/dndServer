package me.alexksysx.model.bindModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.alexksysx.model.gameClass.GameClass;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Proxy(lazy = false)
public class CharacterClass {
    @Id
    @GeneratedValue
    @Column(name = "character_class_id")
    private Long id;
    private Integer level;
    private Boolean isFirst;
    @ManyToOne(targetEntity = GameClass.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "gameclass_id", nullable = false, updatable = false)
    private GameClass gameClass;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name = "feature_choices_options",
            joinColumns = {@JoinColumn(name = "character_class_id")},
            inverseJoinColumns = {@JoinColumn(name = "chioce_id")})
    private List<FeatureChoice> featureChoices;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name = "amount_counter_feature",
    joinColumns = {@JoinColumn(name = "character_class_id")},
    inverseJoinColumns = {@JoinColumn(name = "counter_value")})
    private List<CounterFeatureValue> counterFeatureValues;
}
