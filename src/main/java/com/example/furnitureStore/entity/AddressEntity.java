package com.example.furnitureStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String city;
    String street;
    Integer building;
    Integer apartment;
//    @OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
//    private Set<StockEntity> stock;
}
