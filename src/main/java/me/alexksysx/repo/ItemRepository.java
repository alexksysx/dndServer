package me.alexksysx.repo;

import me.alexksysx.model.item.Armor;
import me.alexksysx.model.item.Item;
import me.alexksysx.repo.dao.ItemDao;
import java.util.List;

import javax.transaction.Transactional;

@Transactional
public interface ItemRepository extends ItemDao<Item> {
    List<Item> getAllByIdIn(List<Long> ids);
    List<Armor> getAllByType(String type);
}
