package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.BenefitSet;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl.BenefitSetFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by LILO on 2016/05/07.
 */
public class BenefitSetFactoryTest {
    private BenefitSetFactory benefitSetFactory;
    private BenefitSet benefitSet;

    @Before
    public void setUp() throws Exception {
        benefitSetFactory = BenefitSetFactoryImpl.getInstance();
    }

    @Test
    public void testBenefitSet() throws Exception {
        benefitSet = benefitSetFactory.createBenefitSet(123456789L,"Health","Life and Disability",250);
        Assert.assertEquals(benefitSet.getInsuranceCoverage(),"Health");
    }

    @Test
    public void testBenefitSetUpdate() throws Exception {
        benefitSet = benefitSetFactory.createBenefitSet(123456789L,"Health","Life and Disability",250);
        BenefitSet updateBenefitSet = new BenefitSet.Builder().copy(benefitSet).benefitCost(300).build();
        Assert.assertEquals(updateBenefitSet.getBenefitCost(),300);
    }
}
