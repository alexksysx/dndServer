package me.alexksysx.model.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import java.io.Serializable;

@Entity
@Proxy(lazy = false)
@Inheritance
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String source;
    private String description;
    private Double weight;
    private String type;
    private String cost;
}
