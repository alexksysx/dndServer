package me.alexksysx.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRace {
    @Id
    @GeneratedValue
    @Column(name = "subrace_id")
    private Long id;

    @JsonIgnoreProperties("subRaces")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToMany(mappedBy = "subRaces", fetch = FetchType.EAGER)
    List<Race> races;
}
