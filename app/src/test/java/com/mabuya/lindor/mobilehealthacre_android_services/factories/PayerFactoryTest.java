package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Payer;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl.PayerFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by LILO on 2016/05/07.
 */
public class PayerFactoryTest {
    private PayerFactory payerFactory;
    private Payer payer;

    @Before
    public void setUp() throws Exception {
        payerFactory = PayerFactoryImpl.getInstance();
    }

    @Test
    public void testPayer() throws Exception {
        payer = payerFactory.createPayer(123456789L,"213036223","Savings","FNB");
        Assert.assertEquals(payer.getAccNum(),"213036223");
    }

    @Test
    public void testPayerUpdate() throws Exception {
        payer = payerFactory.createPayer(123456789L,"213036223","Savings","FNB");
        Payer updatePayer = new Payer.Builder().copy(payer).accType("Cheque").build();
        Assert.assertEquals(updatePayer.getAccType(),"Cheque");
    }
}
