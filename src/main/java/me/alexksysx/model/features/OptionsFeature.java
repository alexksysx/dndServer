package me.alexksysx.model.features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Proxy(lazy = false)
@Table(name = "option_feature")
@AllArgsConstructor
@NoArgsConstructor
public class OptionsFeature {
    @Id @GeneratedValue
    @Column(name = "option_id")
    private Long id;
    private String name;
    private Integer requiredLevel;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToMany
    @JoinTable(name = "option_class_feature",
            joinColumns = {@JoinColumn(name = "option_id")},
            inverseJoinColumns = {@JoinColumn(name = "feature_id")})
    private List<Feature> options;
}
