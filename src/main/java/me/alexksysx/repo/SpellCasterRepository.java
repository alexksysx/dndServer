package me.alexksysx.repo;

import me.alexksysx.model.gameClasses.SpellCaster;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SpellCasterRepository extends CommonClassDAO<SpellCaster> {
}
