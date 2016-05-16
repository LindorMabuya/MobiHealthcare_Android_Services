package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Insured;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl.InsuredFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by LILO on 2016/05/07.
 */
public class InsuredFactoryTest {
    private InsuredFactory insuredFactory;
    private Insured insured;

    @Before
    public void setUp() throws Exception {
        insuredFactory = InsuredFactoryImpl.getInstance();
    }

    @Test
    public void testInsured() throws Exception {
        insured = insuredFactory.createInsured(123456789L,"Person","Old Mutual");
        Assert.assertEquals(insured.getOrganization(),"Old Mutual");
    }

    @Test
    public void testInsuredUpdate() throws Exception {
        insured = insuredFactory.createInsured(123456789L,"Person","Old Mutual");
        Insured updateInsured = new Insured.Builder().copy(insured).organization("Discovery").build();
        Assert.assertEquals(updateInsured.getOrganization(),"Discovery");
    }
}
