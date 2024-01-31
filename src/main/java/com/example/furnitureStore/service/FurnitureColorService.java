package com.example.furnitureStore.service;

import com.example.furnitureStore.converter.FurnitureColorConverter;
import com.example.furnitureStore.domain.FurnitureColor;
import com.example.furnitureStore.repository.FurnitureColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FurnitureColorService {
    private final FurnitureColorRepository repository;

    public FurnitureColor addColor(FurnitureColor color) {
        if(repository.findById(color.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return FurnitureColorConverter.toDomain(
                repository.save(
                        FurnitureColorConverter.toEntity(color)
                )
        );
    }
    public void deleteColor(Long id) {
        repository.deleteById(id);
    }
    public FurnitureColor getColor(Long id) {
        return repository.findById(id).map(FurnitureColorConverter::toDomain).orElse(null);
    }
    public List<FurnitureColor> getColors() {
        return FurnitureColorConverter.toList(repository.findAll());
    }
}
