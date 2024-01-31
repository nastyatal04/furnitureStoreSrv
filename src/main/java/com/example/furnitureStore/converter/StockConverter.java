package com.example.furnitureStore.converter;

import com.example.furnitureStore.domain.Address;
import com.example.furnitureStore.domain.Stock;
import com.example.furnitureStore.entity.AddressEntity;
import com.example.furnitureStore.entity.StockEntity;

import java.util.List;

public class StockConverter {
    public static Stock toDomain(StockEntity entity) {
        Address address = AddressConverter.toDomain(entity.getAddress());
        return Stock.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(address)
                .build();
    }

    public static StockEntity toEntity(Stock stock) {
        AddressEntity address = AddressConverter.toEntity(stock.getAddress());
        return StockEntity.builder()
                .id(stock.getId())
                .name(stock.getName())
                .address(address)
                .build();
    }

    public static List<Stock> toList(List<StockEntity> stocks) {
        return stocks.stream().map(StockConverter::toDomain).toList();
    }

}
