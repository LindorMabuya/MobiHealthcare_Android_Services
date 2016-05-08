package com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Deductible;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.DeductibleFactory;

/**
 * Created by LILO on 2016/05/07.
 */
public class DeductibleFactoryImpl implements DeductibleFactory {
    public static DeductibleFactoryImpl deductibleFactory = null;

    public DeductibleFactoryImpl(){
    }

    public static DeductibleFactoryImpl getIstance(){
        if(deductibleFactory == null)
            deductibleFactory = new DeductibleFactoryImpl();
        return deductibleFactory;
    }

    @Override
    public Deductible createDeductible(Long id) {
        Deductible deductible = new Deductible.Builder().id(id).build();
        return deductible;
    }
}
