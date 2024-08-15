package com.example.backend.account.address.service;

import com.example.backend.account.address.dto.AddressDto;
import com.example.backend.account.address.entity.AddressEntity;
import com.example.backend.account.address.exceptions.classes.AddressExist;
import com.example.backend.account.address.exceptions.classes.AddressNotFound;
import com.example.backend.account.address.repository.AddressRepository;
import com.example.backend.account.user.exceptions.classes.UserNotFound;
import com.example.backend.account.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public void addAddress(AddressDto addressDto, Long userId) throws UserNotFound, AddressExist{
        var user = userRepository.findById(userId).orElseThrow(UserNotFound::new);
        var address = mapToEntity(addressDto);
        if (user.getAddresses().stream().anyMatch(a -> a.equals(address))){
            throw new AddressExist();
        }
        user.getAddresses().add(address);
        addressRepository.save(address);
    }

    private AddressEntity mapToEntity(AddressDto addressDto) {
        var address = new AddressEntity();
        address.setCity(addressDto.city());
        address.setStreet(addressDto.street());
        address.setFlatNumber(addressDto.flatNumber());
        address.setHomeNumber(addressDto.homeNumber());
        address.setPostalCode(addressDto.postalCode());
        return address;
    }

    public void deleteAddress(Long userId, Long addressId) throws UserNotFound, AddressNotFound{
        var user = userRepository.findById(userId).orElseThrow(UserNotFound::new);
        var address = addressRepository.findById(addressId).orElseThrow(AddressNotFound::new);
        user.getAddresses().remove(address);
        userRepository.save(user);
        addressRepository.delete(address);
    }

    public List<AddressEntity> getAllAddress(Long id) throws UserNotFound{
        var user = userRepository.findById(id).orElseThrow(UserNotFound::new);
        return user.getAddresses();
    }
}
