package me.alexksysx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRace {
    @Id @GeneratedValue
    @Column(name = "subrace_id")
//    @ManyToMany(mappedBy = "subraces")
    private Long id;
}
