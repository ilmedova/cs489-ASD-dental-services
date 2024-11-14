package org.example.dentalmanagement.service;

import org.example.dentalmanagement.entity.dto.AddressDTO;
import org.example.dentalmanagement.entity.model.Address;

import java.util.List;

public interface AddressService
{
    public List<AddressDTO> getAllAddresses() ;
}
