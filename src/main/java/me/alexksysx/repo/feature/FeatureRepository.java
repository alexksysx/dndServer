package me.alexksysx.repo.feature;

import me.alexksysx.model.features.Feature;
import me.alexksysx.repo.dao.FeatureDao;

import javax.transaction.Transactional;

@Transactional
public interface FeatureRepository extends FeatureDao<Feature> {
}
