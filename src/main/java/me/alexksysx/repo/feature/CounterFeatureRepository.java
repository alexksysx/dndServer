package me.alexksysx.repo.feature;

import me.alexksysx.model.features.CounterFeature;
import me.alexksysx.repo.dao.FeatureDao;

import javax.transaction.Transactional;

@Transactional
public interface CounterFeatureRepository extends FeatureDao<CounterFeature> {
}
