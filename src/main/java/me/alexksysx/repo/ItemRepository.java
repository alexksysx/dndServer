package me.alexksysx.repo;

import me.alexksysx.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    public ArrayList<Item> findBySource (String source);
}
