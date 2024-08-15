package com.example.backend.account.address.repository;

import com.example.backend.account.address.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
