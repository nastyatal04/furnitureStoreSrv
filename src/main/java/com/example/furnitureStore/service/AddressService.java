package com.example.furnitureStore.service;

import com.example.furnitureStore.converter.AddressConverter;
import com.example.furnitureStore.domain.Address;
import com.example.furnitureStore.entity.AddressEntity;
import com.example.furnitureStore.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository repository;

    public Address getAddress(Long id) {
        return repository.findById(id).map(AddressConverter::toDomain).orElse(null);
    }

    public List<Address> getAddresses() {
        return AddressConverter.toList(repository.findAll());
    }

    public Address addAddress(Address address) {
        if(repository.findById(address.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return AddressConverter.toDomain(
                repository.save(AddressConverter.toEntity(address))
        );
    }

    public void deleteAddress(Long id) {
        repository.deleteById(id);
    }

    public Address updateAddress(Address address) {
        Optional<AddressEntity> addressEntity = repository.findById(address.getId());
        addressEntity.ifPresent(repoAddress -> {
            repoAddress.setId(address.getId());
            repoAddress.setCity(address.getCity());
            repoAddress.setStreet(address.getStreet());
            repoAddress.setBuilding(address.getBuilding());
            repoAddress.setApartment(address.getApartment());
            repository.save(repoAddress);
        });
        return addressEntity.map(AddressConverter::toDomain).orElse(null);
    }
}
