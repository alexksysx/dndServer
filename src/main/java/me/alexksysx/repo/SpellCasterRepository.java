package me.alexksysx.repo;

import me.alexksysx.model.gameClasses.SpellCaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellCasterRepository extends CommonClassDAO<SpellCaster>, JpaRepository<SpellCaster, Long> {
}
