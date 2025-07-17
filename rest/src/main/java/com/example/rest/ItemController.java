package com.example.rest;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/items")

public class ItemController {
    private List<Item> items = new ArrayList<>();

    @GetMapping
    public List<Item> getAllItems() {
        return items;
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @PostMapping
    public Item add(@RequestBody Item item) {
        items.add(item);
        return item;
    }

    @DeleteMapping("/{id}")
    public Item delete(@PathVariable int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return items.remove(i);
            }
        }
        return null;
    }
}
