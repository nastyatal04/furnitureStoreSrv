package com.example.furnitureStore.service;

import com.example.furnitureStore.converter.FurnitureConverter;
import com.example.furnitureStore.converter.StockConverter;
import com.example.furnitureStore.domain.Furniture;
import com.example.furnitureStore.entity.FurnitureColorEntity;
import com.example.furnitureStore.entity.FurnitureEntity;
import com.example.furnitureStore.entity.FurnitureSizeEntity;
import com.example.furnitureStore.entity.StockEntity;
import com.example.furnitureStore.repository.FurnitureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FurnitureService {
    private final FurnitureRepository repository;
    public Furniture addFurniture(Furniture furniture){
        if(repository.findById(furniture.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return FurnitureConverter.toDomain(
                repository.save(FurnitureConverter.toEntity(furniture))
        );
    }
    public void deleteFurniture(Long id) {
        repository.deleteById(id);
    }
    public Furniture updateFurniture(Furniture furniture) {
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
        Optional<FurnitureEntity> repositoryFurniture = repository.findById(furniture.getId());
        repositoryFurniture.ifPresent(repoFurn -> {
                    repoFurn.setId(furniture.getId());
                    repoFurn.setFurnitureType(furniture.getFurnitureType().name());
                    repoFurn.setName(furniture.getName());
                    repoFurn.setSize(size);
                    repoFurn.setWeight(furniture.getWeight());
                    repoFurn.setColor(color);
                    repoFurn.setStock(stock);
                    repoFurn.setPrice(furniture.getPrice());
                    repository.save(repoFurn);
        });
        return repositoryFurniture.map(FurnitureConverter::toDomain).orElse(null);
    }
    public Furniture getFurniture(Long id) {
        return repository.findById(id)
                .map(FurnitureConverter::toDomain)
                .orElse(null);
    }
    public List<Furniture> getFurnitureList() {
        return FurnitureConverter.toList(repository.findAll());
    }
}
