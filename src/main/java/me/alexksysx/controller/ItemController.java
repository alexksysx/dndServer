package me.alexksysx.controller;

import me.alexksysx.model.item.Armor;
import me.alexksysx.model.item.Item;
import me.alexksysx.model.item.Weapon;
import me.alexksysx.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public Item createItem(@RequestBody Item item) {
        itemRepository.save(item);
        return item;
    }

    @PostMapping(value = "/weapon", consumes = "application/json", produces = "application/json")
    public Weapon createWeapon(@RequestBody Weapon weapon) {
        itemRepository.save(weapon);
        return weapon;
    }

    @PostMapping(value = "/armor", consumes = "application/json", produces = "application/json")
    public Armor createArmor(@RequestBody Armor armor) {
        itemRepository.save(armor);
        return armor;
    }

    @RequestMapping(produces = "application/json")
    public List<Item> list() {
        return itemRepository.findAll();
    }
}
