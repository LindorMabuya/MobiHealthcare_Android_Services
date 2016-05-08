package com.mabuya.lindor.mobilehealthacre_android_services.restapi.resources;


/**
 * Created by 213036223 on 4/17/2016.
 */
public class ThirdPartyResource extends com.mabuya.lindor.mobilehealthacre_android_services.domain.Provider {
    public ThirdPartyResource(Builder builder) {
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
