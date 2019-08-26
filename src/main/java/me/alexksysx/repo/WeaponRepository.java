package me.alexksysx.repo;

import me.alexksysx.model.item.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
    public ArrayList<Weapon> findBySource(String source);
}
