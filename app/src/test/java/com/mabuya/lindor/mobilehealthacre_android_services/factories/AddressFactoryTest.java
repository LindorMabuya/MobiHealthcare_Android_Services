package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Address;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl.AddressFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by LILO on 2016/05/07.
 */
public class AddressFactoryTest {
    private AddressFactory addressFactory;
    private Address address;

    @Before
    public void setUp() throws Exception {
        addressFactory = AddressFactoryImpl.getInstance();
    }

    @Test
    public void testAddress() throws Exception {
        address = addressFactory.createAddress(123456789L,3,"Kotze","Gardens","Cape Town",8001);
        Assert.assertEquals(address.getStreetNumber(),3);
    }

    @Test
    public void testUpdateAddress() throws Exception {
        address = addressFactory.createAddress(123456789L,3,"Kotze","Gardens","Cape Town",8001);
        Address updateAddress = new Address.Builder().copy(address).streetName("kloof").build();
        Assert.assertEquals(updateAddress.getStreetName(),"kloof");
    }
}
