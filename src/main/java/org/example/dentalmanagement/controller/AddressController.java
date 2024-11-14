package org.example.dentalmanagement.controller;

import org.example.dentalmanagement.entity.dto.AddressDTO;
import org.example.dentalmanagement.entity.model.Address;
import org.example.dentalmanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }
}