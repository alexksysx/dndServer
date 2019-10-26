package me.alexksysx.repo;

import me.alexksysx.model.items.Weapon;
import me.alexksysx.repo.dao.ItemDao;

import javax.transaction.Transactional;

@Transactional
public interface WeaponRepository extends ItemDao<Weapon> {

}
