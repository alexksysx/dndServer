package me.alexksysx.repo.dao;

import me.alexksysx.model.items.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ItemDao<EntityType extends Item> extends JpaRepository<Item, Long> {
}
