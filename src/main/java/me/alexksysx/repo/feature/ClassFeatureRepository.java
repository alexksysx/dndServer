package me.alexksysx.repo.feature;

import me.alexksysx.model.gameClass.ClassFeature;
import me.alexksysx.repo.dao.FeatureDao;

import javax.transaction.Transactional;

@Transactional
public interface ClassFeatureRepository extends FeatureDao<ClassFeature> {
}
