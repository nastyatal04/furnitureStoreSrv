package com.example.furnitureStore.repository;

import com.example.furnitureStore.entity.FurnitureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<FurnitureEntity, Long> {
}
