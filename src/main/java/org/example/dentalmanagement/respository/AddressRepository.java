package org.example.dentalmanagement.respository;

import org.example.dentalmanagement.entity.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByOrderByCityAsc();
}
