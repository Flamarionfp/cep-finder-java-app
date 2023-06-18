package com.example.cepfinder.services;

import com.example.cepfinder.dtos.GetAddressByCepDTO;
import com.example.cepfinder.entities.Address;

import java.io.IOException;


public class GetAddressByCep implements GetAddressByCepDTO {
    private GetAddressByCepDTO getAddressByCepProvider;

    public GetAddressByCep(GetAddressByCepDTO getAddressByCepProvider) {
        this.getAddressByCepProvider = getAddressByCepProvider;
    }

  public Address execute(String postalCode) throws Exception {
      Address address = getAddressByCepProvider.execute(postalCode);

      return address;
  }
}
