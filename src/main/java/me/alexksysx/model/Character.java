package me.alexksysx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Proxy(lazy = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(targetEntity = Race.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "race_id", nullable = false, updatable = false)
    private Race race;
}
