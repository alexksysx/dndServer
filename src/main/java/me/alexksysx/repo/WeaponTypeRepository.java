package me.alexksysx.repo;

import me.alexksysx.model.type.WeaponType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeaponTypeRepository extends JpaRepository<WeaponType, Long> {
    Boolean existsWeaponTypeByName(String name);
    List<WeaponType> findAllByIdIn(List<Long> ids);
}
