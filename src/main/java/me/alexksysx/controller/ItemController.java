package me.alexksysx.controller;

import me.alexksysx.model.Item;
import me.alexksysx.model.items.Armor;
import me.alexksysx.model.items.Weapon;
import me.alexksysx.repo.ArmorRepository;
import me.alexksysx.repo.ItemRepository;
import me.alexksysx.repo.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    WeaponRepository weaponRepository;

    @Autowired
    ArmorRepository armorRepository;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public Item createItem(@RequestBody Item item) {
        itemRepository.save(item);
        return item;
    }

    @PostMapping(value = "/create/weapon", consumes = "application/json", produces = "application/json")
    public Weapon createWeapon(@RequestBody Weapon weapon) {
        weaponRepository.save(weapon);
        return weapon;
    }

    @PostMapping(value = "/create/armor", consumes = "application/json", produces = "application/json")
    public Armor createArmor(@RequestBody Armor armor) {
        armorRepository.save(armor);
        return armor;
    }

    @RequestMapping(produces = "application/json")
    public List<Item> list() {
        return itemRepository.findAll();
    }
}
