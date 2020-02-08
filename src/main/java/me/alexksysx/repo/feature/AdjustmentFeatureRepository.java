package me.alexksysx.repo.feature;

import me.alexksysx.model.gameClass.features.AdjustmentFeature;
import me.alexksysx.repo.dao.FeatureDao;

import javax.transaction.Transactional;

@Transactional
public interface AdjustmentFeatureRepository extends FeatureDao<AdjustmentFeature> {
}
