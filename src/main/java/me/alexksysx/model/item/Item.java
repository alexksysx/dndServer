package me.alexksysx.model.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String source;
    @Getter @Setter private String description;
    @Getter @Setter private Double weight;
    @Getter @Setter private String type;
    @Getter @Setter private String cost;
}
