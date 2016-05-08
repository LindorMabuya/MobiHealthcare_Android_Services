package com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Insured;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.InsuredFactory;

/**
 * Created by LILO on 2016/05/07.
 */
public class InsuredFactoryImpl implements InsuredFactory{
    public static  InsuredFactoryImpl insuredFactory = null;

    public InsuredFactoryImpl(){
    }

    public static  InsuredFactoryImpl getInstance(){
        if(insuredFactory == null)
            insuredFactory = new InsuredFactoryImpl();
        return insuredFactory;
    }

    @Override
    public Insured createInsured(Long id, String coveredByInsurance, String organization) {
        Insured insured = new Insured.Builder().id(id).coveredByInsurance(coveredByInsurance)
                .organization(organization).build();
        return insured;
    }
}
