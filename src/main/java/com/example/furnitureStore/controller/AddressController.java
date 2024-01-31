package com.example.furnitureStore.controller;

import com.example.furnitureStore.domain.Address;
import com.example.furnitureStore.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService service;

    @GetMapping
    public List<Address> getAddresses() {
        return service.getAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Long id) {
        return service.getAddress(id);
    }

    @PostMapping()
    public Address addAddress(@RequestBody Address address) {
        return service.addAddress(address);
    }

    @PutMapping()
    public Address updateAddress(@RequestBody Address address) {
        return service.updateAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        service.deleteAddress(id);
    }

}
