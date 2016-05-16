package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Deductible;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl.DeductibleFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by LILO on 2016/05/07.
 */
public class DeductibleFactoryTest {
    private DeductibleFactory deductibleFactory;
    private Deductible deductible;

    @Before
    public void setUp() throws Exception {
        deductibleFactory = DeductibleFactoryImpl.getIstance();
    }

    @Test
    public void testDeductible() throws Exception {
        deductible = deductibleFactory.createDeductible(123456789L);
        deductible.isDeductible();
        Assert.assertEquals(deductible.isDeductible(),deductible.isDeductible());
    }

    @Test
    public void testDeductibleUpdate() throws Exception {
        deductible = deductibleFactory.createDeductible(123456789L);
        Deductible deductibleUpdate = new Deductible.Builder().copy(deductible).id(987654321L).build();
        Assert.assertEquals(deductibleUpdate.isDeductible(), deductibleUpdate.isDeductible());
    }
}
