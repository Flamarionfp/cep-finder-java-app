package com.example.cepfinder.mappers;

import com.example.cepfinder.entities.Address;
import com.example.cepfinder.entities.ViaCepAddress;

public class ViaCepAddressMapper {
   public static Address mapToAddress(ViaCepAddress viaCepAddress) {
       Address address = new Address();

       address.setCity(viaCepAddress.getLocalidade());
       address.setCounty(viaCepAddress.getBairro());
       address.setStreet(viaCepAddress.getLogradouro());
       address.setUf(viaCepAddress.getUf());

       return address;
   }
}
