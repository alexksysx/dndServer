package me.alexksysx.repo;

import me.alexksysx.model.item.Item;
import me.alexksysx.repo.dao.ItemDao;

import javax.transaction.Transactional;

@Transactional
public interface ItemRepository extends ItemDao<Item> {
}
