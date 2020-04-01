package me.alexksysx.repo.bindRepos;

import me.alexksysx.model.bindModel.CounterFeatureValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterFeatureValueRepository extends JpaRepository<CounterFeatureValue, Long> {
}
