package com.example.backend.account.address.entity;

import com.example.backend.account.user.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String postalCode;
    private String homeNumber;
    private String flatNumber;
    @ManyToMany(mappedBy = "addresses")
    @JsonIgnore
    private List<UserEntity> users = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressEntity that)) return false;
        return Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(postalCode, that.postalCode) && Objects.equals(homeNumber, that.homeNumber) && Objects.equals(flatNumber, that.flatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, postalCode, homeNumber, flatNumber);
    }
}
