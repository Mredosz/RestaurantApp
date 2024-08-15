package com.example.backend.account.address;

import com.example.backend.account.address.dto.AddressDto;
import com.example.backend.account.address.entity.AddressEntity;
import com.example.backend.account.address.exceptions.classes.AddressExist;
import com.example.backend.account.address.service.AddressService;
import com.example.backend.account.user.exceptions.classes.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    //201 or 404 or 409
    @PostMapping("/{userId}/add")
    public ResponseEntity<Void> addAddressToUser(@RequestBody AddressDto addressDto, @PathVariable Long userId) throws UserNotFound, AddressExist {
        addressService.addAddress(addressDto, userId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //204 or 404
    @DeleteMapping("/{userId}/delete/{addressId}")
    public ResponseEntity<Void> deleteAddressFromUser(@PathVariable Long userId, @PathVariable Long addressId)throws UserNotFound{
        addressService.deleteAddress(userId, addressId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    //200
    @GetMapping("/{userId}/all")
    public ResponseEntity<List<AddressEntity>> getAllAddresses(@PathVariable Long userId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(addressService.getAllAddress(userId));
    }
}
