package com.example.furnitureStore.converter;

import com.example.furnitureStore.domain.FurnitureColor;
import com.example.furnitureStore.entity.FurnitureColorEntity;

import java.util.List;

public class FurnitureColorConverter {
    public static FurnitureColor toDomain(FurnitureColorEntity entity) {
        return FurnitureColor.builder()
                .id(entity.getId())
                .name(entity.getName())
                .hex(entity.getHex())
                .build();
    }

    public static FurnitureColorEntity toEntity(FurnitureColor color) {
        return FurnitureColorEntity.builder()
                .id(color.getId())
                .name(color.getName())
                .hex(color.getHex())
                .build();
    }

    public static List<FurnitureColor> toList(List<FurnitureColorEntity> entities) {
        return entities.stream().map(FurnitureColorConverter::toDomain).toList();
    }
}
