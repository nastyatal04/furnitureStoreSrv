package com.example.furnitureStore.controller;

import com.example.furnitureStore.domain.Stock;
import com.example.furnitureStore.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {
    private final StockService service;
    @GetMapping("/{id}")
    public Stock getStock(@PathVariable Long id) {
        return service.getStock(id);
    }
    @GetMapping
    public List<Stock> getStocks() {
        return service.getList();
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return service.addStock(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        service.deleteStock(id);
    }

    @PutMapping
    public Stock updateStock(@RequestBody Stock stock) {
        return service.updateStock(stock);
    }
}
