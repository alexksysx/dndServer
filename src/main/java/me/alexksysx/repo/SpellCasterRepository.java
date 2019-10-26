package me.alexksysx.repo;

import me.alexksysx.model.gameClasses.SpellCaster;
import me.alexksysx.repo.dao.CommonClassDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SpellCasterRepository extends CommonClassDao<SpellCaster> {
}
