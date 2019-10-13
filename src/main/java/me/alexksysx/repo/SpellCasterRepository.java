package me.alexksysx.repo;

import me.alexksysx.model.gameClasses.SpellCaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SpellCasterRepository extends CommonClassDAO<SpellCaster>, JpaRepository<SpellCaster, Long> {
}
