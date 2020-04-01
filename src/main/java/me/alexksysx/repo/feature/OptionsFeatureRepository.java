package me.alexksysx.repo.feature;

import me.alexksysx.model.features.OptionsFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsFeatureRepository extends JpaRepository<OptionsFeature, Long> {
}
