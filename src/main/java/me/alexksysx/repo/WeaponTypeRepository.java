package me.alexksysx.repo;

import me.alexksysx.model.type.WeaponType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponTypeRepository extends JpaRepository<WeaponType, Long> {
    Boolean existsWeaponTypeByName(String name);
}
