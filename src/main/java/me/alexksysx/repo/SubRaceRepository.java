package me.alexksysx.repo;

import me.alexksysx.model.SubRace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface SubRaceRepository extends JpaRepository<SubRace, Long> {
    Set<SubRace> findByIdIn(List<Long> ids);
}
