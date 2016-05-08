package com.mabuya.lindor.mobilehealthacre_android_services.restapi.api;

import com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources.ServiceResource;

import java.io.IOException;
import java.util.Set;

/**
 * Created by LILO on 2016/05/09.
 */
public interface ServiceAPI {
    Set<ServiceResource> getService()throws IOException;
}
