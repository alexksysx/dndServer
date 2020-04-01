package me.alexksysx.model.features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "feature")
@Data
@Proxy(lazy = false)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
public class Feature {
    @Id @GeneratedValue
    @Column(name = "feature_id")
    private Long id;
    private String name;
    private Integer requiredLevel;
    @Column(columnDefinition = "TEXT")
    private String description;
}
