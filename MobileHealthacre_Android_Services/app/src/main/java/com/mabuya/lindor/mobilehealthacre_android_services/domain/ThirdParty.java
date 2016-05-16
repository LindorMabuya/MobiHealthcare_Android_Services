package com.mabuya.lindor.mobilehealthacre_android_services.domain;


import java.util.List;

/**
 * Created by 213036223 on 4/17/2016.
 */
public class ThirdParty extends Provider{
    public ThirdParty(Builder builder) {
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
