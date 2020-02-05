package me.alexksysx.repo;

import me.alexksysx.model.type.DamageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamageTypeRepository extends JpaRepository<DamageType, Long> {
    boolean existsDamageTypeByNameAndDescription(String name, String description);
    List<DamageType> findAllByIdIn(List<Long> ids);
}
