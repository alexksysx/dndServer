package me.alexksysx.controller;

import me.alexksysx.dto.WeaponDto;
import me.alexksysx.model.item.Armor;
import me.alexksysx.model.item.Item;
import me.alexksysx.model.item.Weapon;
import me.alexksysx.repo.DamageTypeRepository;
import me.alexksysx.repo.ItemRepository;
import me.alexksysx.repo.WeaponTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private WeaponTypeRepository weaponTypeRepository;

    @Autowired
    private DamageTypeRepository damageTypeRepository;

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public Item createItem(@RequestBody Item item) {
        itemRepository.save(item);
        return item;
    }

    @PostMapping(value = "/weapon", consumes = "application/json", produces = "application/json")
    public Weapon createWeapon(@RequestBody WeaponDto weaponDto) {
        Weapon weapon = getWeaponFromDto(weaponDto);
        itemRepository.save(weapon);
        return weapon;
    }

    @PostMapping(value = "/armor", consumes = "application/json", produces = "application/json")
    public Armor createArmor(@RequestBody Armor armor) {
        return itemRepository.save(armor);
    }

    @GetMapping(produces = "application/json")
    public List<Item> list() {
        return itemRepository.findAll();
    }

    @GetMapping(value ="armor", produces = "application/json")
    public List<Armor> getAllArmor() {
        return itemRepository.getAllByType("armor");
    }

    private Weapon getWeaponFromDto(WeaponDto dto) {
        Weapon weapon = new Weapon();
        BeanUtils.copyProperties(dto, weapon, "damageTypes", "weaponTypes");
        weapon.setWeaponTypes(weaponTypeRepository.findAllByIdIn(dto.getWeaponTypes()));
        weapon.setDamageTypes(damageTypeRepository.findAllByIdIn(dto.getDamageTypes()));
        return weapon;
    }
}
