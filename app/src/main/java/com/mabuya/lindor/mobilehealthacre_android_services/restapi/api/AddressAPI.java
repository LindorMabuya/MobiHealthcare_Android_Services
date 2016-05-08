package com.mabuya.lindor.mobilehealthacre_android_services.restapi.api;

import com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources.AddressResource;

import java.io.IOException;
import java.util.Set;

/**
 * Created by LILO on 2016/05/09.
 */
public interface AddressAPI {
    Set<AddressResource> getAddress() throws IOException;
}
