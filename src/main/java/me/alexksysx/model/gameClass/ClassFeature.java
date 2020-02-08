package me.alexksysx.model.gameClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Data
@Proxy(lazy = false)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
public class ClassFeature {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Integer requiredLevel;
    private String description;
}
