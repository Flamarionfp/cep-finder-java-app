package com.example.cepfinder.dtos;

import com.example.cepfinder.entities.Address;

public interface GetAddressByCepDTO {
    public Address execute(String postalCode) throws Exception;
}
