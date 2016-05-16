package com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Service;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.ServiceFactory;

import java.util.List;

/**
 * Created by LILO on 2016/05/07.
 */
public class ServiceFactoryImpl implements ServiceFactory {
    public static ServiceFactoryImpl serviceFactory = null;

    public ServiceFactoryImpl(){
    }

    public static ServiceFactoryImpl getInstance(){
        if(serviceFactory == null)
            serviceFactory = new ServiceFactoryImpl();
        return  serviceFactory;
    }

    @Override
    public Service createService(Long id, List<String> policy) {
        Service service = new Service.Builder().id(id).policy(policy).build();
        return  service;
    }
}
