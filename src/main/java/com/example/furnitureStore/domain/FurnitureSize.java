package com.example.furnitureStore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FurnitureSize {
    Long id;
    Float width;
    Float depth;
    Float height;
}
