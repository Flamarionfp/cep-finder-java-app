package com.example.cepfinder.providers;

import com.example.cepfinder.dtos.GetAddressByCepDTO;
import com.example.cepfinder.entities.Address;
import com.example.cepfinder.entities.ViaCepAddress;
import com.example.cepfinder.http.request.ViaCepRequest;
import com.example.cepfinder.mappers.ViaCepAddressMapper;
import com.google.gson.Gson;

public class ViaCepGetAddressByCep implements GetAddressByCepDTO {

    public Address execute(String postalCode) throws Exception {
        String responseBody = ViaCepRequest.handle(postalCode);
        ViaCepAddress viaCepAddress = new Gson().fromJson(responseBody, ViaCepAddress.class);

        return ViaCepAddressMapper.mapToAddress(viaCepAddress);
    }
}
