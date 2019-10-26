package me.alexksysx.controller;

import me.alexksysx.model.Item;
import me.alexksysx.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public Item create(@RequestBody Item item) {
        itemRepository.save(item);
        return item;
    }

    @RequestMapping(produces = "application/json")
    public List<Item> list() {
        return itemRepository.findAll();
    }
}
