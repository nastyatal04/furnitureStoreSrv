package com.example.furnitureStore.controller;

import com.example.furnitureStore.domain.FurnitureColor;
import com.example.furnitureStore.service.FurnitureColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/color")
public class FurnitureColorController {
    private final FurnitureColorService service;
    @GetMapping
    public List<FurnitureColor> getColors(){
        return service.getColors();
    }
    @GetMapping("/{id}")
    public FurnitureColor getColor(@PathVariable Long id) {
        return service.getColor(id);
    }
    @PostMapping
    public FurnitureColor addColor(@RequestBody FurnitureColor color) {
        return service.addColor(color);
    }
    @DeleteMapping("/{id}")
    public void deleteColor(@PathVariable Long id) {
        service.deleteColor(id);
    }
}
