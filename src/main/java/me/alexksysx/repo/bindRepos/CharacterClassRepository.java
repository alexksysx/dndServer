package me.alexksysx.repo.bindRepos;

import me.alexksysx.model.bindModel.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long> {
}
