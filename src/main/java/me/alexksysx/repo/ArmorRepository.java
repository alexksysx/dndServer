package me.alexksysx.repo;

import me.alexksysx.model.items.Armor;
import me.alexksysx.repo.dao.ItemDao;

import javax.transaction.Transactional;

@Transactional
public interface ArmorRepository extends ItemDao<Armor> {
}
