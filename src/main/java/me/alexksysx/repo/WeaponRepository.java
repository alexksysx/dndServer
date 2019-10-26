package me.alexksysx.repo;

import me.alexksysx.model.items.Weapon;
import me.alexksysx.repo.dao.ItemDao;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends ItemDao<Weapon> {

}
