package com.example.cepfinder.utils;

import com.example.cepfinder.entities.Address;

public class FormatAddress {
    public static String toString(Address address) {
        String street = address.getStreet();
        String streetLabel = street.length() > 0 ? "Rua " + address.getStreet() + ", " : "";

        return streetLabel + address.getCounty() + " " + address.getCity() + ", " + address.getUf();
    }
}
