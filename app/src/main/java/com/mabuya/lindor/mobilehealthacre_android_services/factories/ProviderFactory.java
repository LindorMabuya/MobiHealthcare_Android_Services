package com.mabuya.lindor.mobilehealthacre_android_services.factories;


import com.mabuya.lindor.mobilehealthacre_android_services.domain.Provider;

/**
 * Created by 213036223 on 4/17/2016.
 */
public interface ProviderFactory {
    Provider createProvider(Long id, String providerName, double pricePerMonth);
}
