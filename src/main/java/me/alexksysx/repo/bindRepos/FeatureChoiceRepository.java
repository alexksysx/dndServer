package me.alexksysx.repo.bindRepos;

import me.alexksysx.model.bindModel.FeatureChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureChoiceRepository extends JpaRepository<FeatureChoice, Long> {
}
