package me.alexksysx.repo.dao;

import me.alexksysx.model.features.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FeatureDao<EntityType extends Feature> extends JpaRepository<EntityType, Long> {
}
