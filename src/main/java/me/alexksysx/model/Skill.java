package me.alexksysx.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Proxy(lazy = false)
public class Skill {
    @Id @GeneratedValue
    @Getter
    @Setter
    private Long id;
    @Getter @Setter String name;
    @Getter @Setter String source;
}
