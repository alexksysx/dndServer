package me.alexksysx.repo;

import me.alexksysx.model.Item;
import me.alexksysx.repo.dao.ItemDao;

import javax.transaction.Transactional;

@Transactional
public interface ItemRepository extends ItemDao<Item> {
}
