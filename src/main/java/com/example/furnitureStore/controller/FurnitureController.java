package com.example.furnitureStore.controller;

import com.example.furnitureStore.domain.Furniture;
import com.example.furnitureStore.service.FurnitureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/furniture
//http://localhost:8080/swagger-ui/index.html
//http://localhost:8080/h2-console

@RestController
@RequiredArgsConstructor
@RequestMapping("/furniture")
public class FurnitureController {
    private final FurnitureService service;
    @GetMapping
    public List<Furniture> getFurniture() {
        return service.getFurnitureList();
    }
    @GetMapping("/{id}")
    public Furniture getFurniture(@PathVariable Long id) {
        return service.getFurniture(id);
    }
    @PostMapping
    public Furniture addFurniture(@RequestBody Furniture furniture) {
        return service.addFurniture(furniture);
    }
    @PutMapping
    public Furniture updateFurniture(@RequestBody Furniture furniture) {
        return service.updateFurniture(furniture);
    }
    @DeleteMapping("/{id}")
    public void deleteFurniture(@PathVariable Long id) {
        service.deleteFurniture(id);
    }

//    @Transactional
//    @GetMapping("/test")
//    public FurnitureEntity test() {
//
//    }
}
