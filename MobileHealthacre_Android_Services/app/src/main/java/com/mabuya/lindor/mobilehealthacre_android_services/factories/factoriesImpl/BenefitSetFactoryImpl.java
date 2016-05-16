package com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.BenefitSet;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.BenefitSetFactory;

/**
 * Created by LILO on 2016/05/07.
 */
public class BenefitSetFactoryImpl implements BenefitSetFactory{
    private static BenefitSetFactoryImpl benefitSetFactory = null;

    public BenefitSetFactoryImpl() {
    }

    public static  BenefitSetFactoryImpl getInstance()
    {
        if(benefitSetFactory == null)
            benefitSetFactory = new BenefitSetFactoryImpl();
        return benefitSetFactory;
    }

    @Override
    public BenefitSet createBenefitSet(Long id, String insuranceCoverage, String benefit, double benefitCost) {
        BenefitSet benefitSet = new BenefitSet.Builder().id(id).insuranceCoverage(insuranceCoverage)
                .benefit(benefit).benefitCost(benefitCost).build();
        return benefitSet;
    }
}
