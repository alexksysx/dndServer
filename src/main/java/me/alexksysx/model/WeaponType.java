package me.alexksysx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Data
@Proxy(lazy = false)
@NoArgsConstructor
@AllArgsConstructor
public class WeaponType {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
}
