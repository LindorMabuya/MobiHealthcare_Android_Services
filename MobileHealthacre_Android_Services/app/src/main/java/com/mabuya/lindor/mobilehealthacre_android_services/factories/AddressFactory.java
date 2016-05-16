
package com.mabuya.lindor.mobilehealthacre_android_services.factories;


import com.mabuya.lindor.mobilehealthacre_android_services.domain.Address;

/**
 * Created by LILO on 2016/04/07.
 */
public interface AddressFactory {
     Address createAddress(Long id, int streetNumber, String streetName, String town, String city, int zipCode);
}
