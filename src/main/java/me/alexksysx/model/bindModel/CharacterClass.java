package me.alexksysx.model.bindModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.alexksysx.model.gameClass.CommonClass;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Proxy(lazy = false)
public class CharacterClass {
    @Id
    @GeneratedValue
    private Long id;
    private Integer level;
    private Boolean isFirst;
    @ManyToOne(targetEntity = CommonClass.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "gameclass_id", nullable = false, updatable = false)
    private CommonClass gameClass;
}
