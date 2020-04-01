package me.alexksysx.repo;

import me.alexksysx.model.gameClass.GameClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GameClassRepository extends JpaRepository<GameClass, Long> {
}
