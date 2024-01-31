package com.example.furnitureStore.service;

import com.example.furnitureStore.converter.AddressConverter;
import com.example.furnitureStore.converter.StockConverter;
import com.example.furnitureStore.domain.Stock;
import com.example.furnitureStore.entity.AddressEntity;
import com.example.furnitureStore.entity.StockEntity;
import com.example.furnitureStore.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository repository;

    public Stock getStock(Long id) {
        return repository.findById(id).map(StockConverter::toDomain).orElse(null);
    }

    public List<Stock> getList() {
        return StockConverter.toList(repository.findAll());
    }

    public Stock addStock(Stock stock) {
        if (repository.findById(stock.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return StockConverter.toDomain(repository.save(StockConverter.toEntity(stock)));
    }

    public void deleteStock(Long id) {
        repository.deleteById(id);
    }

    public Stock updateStock(Stock stock) {
        AddressEntity address = AddressConverter.toEntity(stock.getAddress());
        Optional<StockEntity> stockEntity = repository.findById(stock.getId());
        stockEntity.ifPresent(repoStock -> {
            repoStock.setId(stock.getId());
            repoStock.setName(stock.getName());
            repoStock.setAddress(address);
            repository.save(repoStock);
        });
        return stockEntity.map(StockConverter::toDomain).orElse(null);
    }
}
