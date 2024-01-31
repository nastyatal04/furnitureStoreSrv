package com.example.furnitureStore.repository;

import com.example.furnitureStore.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
}
