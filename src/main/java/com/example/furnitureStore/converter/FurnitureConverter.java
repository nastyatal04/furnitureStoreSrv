package com.example.furnitureStore.converter;

import com.example.furnitureStore.domain.*;
import com.example.furnitureStore.entity.FurnitureColorEntity;
import com.example.furnitureStore.entity.FurnitureEntity;
import com.example.furnitureStore.entity.FurnitureSizeEntity;
import com.example.furnitureStore.entity.StockEntity;

import java.util.List;

public class FurnitureConverter {
    public static Furniture toDomain(FurnitureEntity entity) {
        FurnitureType type = FurnitureType.BEDS;
        try {
            type = FurnitureType.valueOf(entity.getFurnitureType());
        } catch (Exception e) {}
        FurnitureSize size = FurnitureSize.builder()
                .id(entity.getSize().getId())
                .width(entity.getSize().getWidth())
                .depth(entity.getSize().getDepth())
                .height(entity.getSize().getHeight())
                .build();
        FurnitureColor color = FurnitureColor.builder()
                .id(entity.getColor().getId())
                .hex(entity.getColor().getHex())
                .name(entity.getColor().getName())
                .build();
        Stock stock = StockConverter.toDomain(entity.getStock());
        return Furniture.builder()
                .id(entity.getId())
                .furnitureType(type)
                .name(entity.getName())
                .size(size)
                .weight(entity.getWeight())
                .color(color)
                .stock(stock)
                .price(entity.getPrice())
                .build();
    }

    public static FurnitureEntity toEntity(Furniture furniture) {
        FurnitureSizeEntity size = FurnitureSizeEntity.builder()
                .id(furniture.getSize().getId())
                .width(furniture.getSize().getWidth())
                .depth(furniture.getSize().getDepth())
                .height(furniture.getSize().getHeight())
                .build();
        FurnitureColorEntity color = FurnitureColorEntity.builder()
                .id(furniture.getColor().getId())
                .hex(furniture.getColor().getHex())
                .name(furniture.getColor().getName())
                .build();
        StockEntity stock = StockConverter.toEntity(furniture.getStock());
        return new FurnitureEntity(
                furniture.getId(),
                furniture.getFurnitureType().name(),
                furniture.getName(),
                size,
                furniture.getWeight(),
                color,
                stock,
                furniture.getPrice()
        );
    }

    public static List<Furniture> toList(List<FurnitureEntity> entities) {
        return entities
                .stream()
                .map(FurnitureConverter::toDomain)
                .toList();
    }
}
