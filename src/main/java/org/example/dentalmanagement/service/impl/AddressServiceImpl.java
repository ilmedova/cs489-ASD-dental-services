package org.example.dentalmanagement.service.impl;

import org.example.dentalmanagement.entity.dto.AddressDTO;
import org.example.dentalmanagement.entity.model.Address;
import org.example.dentalmanagement.respository.AddressRepository;
import org.example.dentalmanagement.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepository.findAllByOrderByCityAsc();
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }
}

