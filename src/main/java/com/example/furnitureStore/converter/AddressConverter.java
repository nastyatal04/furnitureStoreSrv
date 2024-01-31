package com.example.furnitureStore.converter;

import com.example.furnitureStore.domain.Address;
import com.example.furnitureStore.entity.AddressEntity;

import java.util.List;

public class AddressConverter {
    public static Address toDomain(AddressEntity entity) {
        return Address.builder()
                .id(entity.getId())
                .city(entity.getCity())
                .street(entity.getStreet())
                .building(entity.getBuilding())
                .apartment(entity.getApartment())
                .build();
    }
    public static AddressEntity toEntity(Address address) {
        return AddressEntity.builder()
                .id(address.getId())
                .city(address.getCity())
                .street(address.getStreet())
                .building(address.getBuilding())
                .apartment(address.getApartment())
                .build();
    }

    public static List<Address> toList(List<AddressEntity> addresses) {
        return addresses.stream().map(AddressConverter::toDomain).toList();
    }
}
