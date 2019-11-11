package me.alexksysx.repo;

import me.alexksysx.model.SubRace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubRaceRepository extends JpaRepository<SubRace, Long> {
    List<SubRace> findByIdIn(List<Long> ids);
}
