
package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Provider;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class HospitalResource extends Provider {


    public HospitalResource(Builder builder) {
        super(builder);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getProviderName() {
        return super.getProviderName();
    }

    @Override
    public double getChargePerMonth() {
        return super.getChargePerMonth();
    }
}
