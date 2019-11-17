package me.alexksysx.repo;

import me.alexksysx.model.type.DamageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageTypeRepository extends JpaRepository<DamageType, Long> {
    boolean existsDamageTypeByNameAndDescription(String name, String description);
}
