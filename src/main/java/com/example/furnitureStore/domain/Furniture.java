package com.example.furnitureStore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Furniture {
    Long id;
    FurnitureType furnitureType;
    String name;
    FurnitureSize size;
    Float weight;
    FurnitureColor color;
    Stock stock;
    Integer price;
}
