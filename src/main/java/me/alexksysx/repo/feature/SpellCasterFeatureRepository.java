package me.alexksysx.repo.feature;

import me.alexksysx.model.gameClass.features.SpellCasterFeature;
import me.alexksysx.repo.dao.FeatureDao;

import javax.transaction.Transactional;

@Transactional
public interface SpellCasterFeatureRepository extends FeatureDao<SpellCasterFeature> {
}
