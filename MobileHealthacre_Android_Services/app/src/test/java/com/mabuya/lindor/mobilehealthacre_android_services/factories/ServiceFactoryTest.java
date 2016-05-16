package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Service;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl.ServiceFactoryImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by LILO on 2016/05/07.
 */
public class ServiceFactoryTest {
    private ServiceFactory serviceFactory;
    private Service service;
    private List<String> policy;

    @Before
    public void setUp() throws Exception {
        serviceFactory = ServiceFactoryImpl.getInstance();
        policy.add("cover");
        policy.add("duration of cover");
        policy.add("amount of premium");
        policy.add("mode of premium");
        policy.add("deductibles");
    }

    @Test
    public void testService() throws Exception {
        service = serviceFactory.createService(123456789L,policy);
        Assert.assertEquals(service.getPolicy(),policy);
    }

    @Test
    public void testServiceUpdate() throws Exception {
        service = serviceFactory.createService(123456789L,policy);
        Service serviceUpdate = new Service.Builder().copy(service).id(987654321L).build();
        Assert.assertEquals(serviceUpdate.getPolicy(),policy);
    }
}
