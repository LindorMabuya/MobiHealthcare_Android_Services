package com.mabuya.lindor.mobilehealthacre_android_services.factories;


import com.mabuya.lindor.mobilehealthacre_android_services.domain.Dependent;

/**
 * Created by 213036223 on 4/17/2016.
 */
public interface DependentFactory {
    Dependent createDependent(String relationToSubscriber);
}
