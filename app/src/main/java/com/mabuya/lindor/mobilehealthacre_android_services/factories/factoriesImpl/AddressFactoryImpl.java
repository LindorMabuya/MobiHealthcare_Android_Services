package com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl;


import com.mabuya.lindor.mobilehealthacre_android_services.domain.Address;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.AddressFactory;

/**
 * Created by LILO on 2016/04/07.
 */
public class AddressFactoryImpl implements AddressFactory {

    private static AddressFactoryImpl addressFactory = null;

    public AddressFactoryImpl() {
    }

    public static  AddressFactoryImpl getInstance()
    {
        if(addressFactory == null)
            addressFactory = new AddressFactoryImpl();
        return addressFactory;
    }

    @Override
    public Address createAddress(Long id, int streetNumber, String streetName, String town, String city, int zipCode) {
        Address address = new Address.Builder().id(id).streetNumber(streetNumber).streetName(streetName)
                .town(town).city(city).zipCode(zipCode).build();
        return address;
    }
}
