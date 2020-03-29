package me.alexksysx.repo.dao;

import me.alexksysx.model.gameClass.ClassFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FeatureDao<EntityType extends ClassFeature> extends JpaRepository<EntityType, Long> {
}
