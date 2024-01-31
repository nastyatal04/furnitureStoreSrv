package com.example.furnitureStore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    Long id;
    String city;
    String street;
    Integer building;
    Integer apartment;
}
