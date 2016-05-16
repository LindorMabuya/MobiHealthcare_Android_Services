package com.mabuya.lindor.mobilehealthacre_android_services.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.mabuya.lindor.mobilehealthacre_android_services.config.util.App;
import com.mabuya.lindor.mobilehealthacre_android_services.config.util.DomainState;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.DemographicInfo;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.AddressRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.DemographicInfoRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.AddressRepositoryImpl;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.DemographicInfoRepositoryImpl;
import com.mabuya.lindor.mobilehealthacre_android_services.services.RegisterAccountService;

//This is a Local Bound Service//
/* I choose this Service because this application needs to communicate with the server after starting it.
 * It is the perfect communication interface to send requests and receive responses either within  particular process or across processes.
 * It is the perfect way for clients to interact with methods in the Server.
 * Potential customers must register then get a response of acceptance, that's why the Local Bound Service was ideal here.
  */

public class RegisterAccountServiceImpl extends Service implements RegisterAccountService {
    final private AddressRepository addressRepository;
    final private DemographicInfoRepository demographicInfoRepository;

    private static RegisterAccountServiceImpl service = null;

    public static RegisterAccountServiceImpl getInstance(){
        if(service == null)
            service = new RegisterAccountServiceImpl();
        return service;
    }

    private final IBinder localBinder = new RegisterServiceBinder();

    private DemographicInfoRepository repo;

    private RegisterAccountServiceImpl(){
        addressRepository = new AddressRepositoryImpl(App.getAppContext());
        demographicInfoRepository = new DemographicInfoRepositoryImpl(App.getAppContext());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class RegisterServiceBinder extends Binder {
        public RegisterAccountServiceImpl getService(){
        return RegisterAccountServiceImpl.this;
         }
    }

    @Override
    public String activateAccount(String email, String password) {
        //activate account
        return DomainState.ACTIVATED.name();
    }

    @Override
    public boolean isAccountActivated() {
        return repo.findAll().size() > 0;
    }

    @Override
    public boolean deactivateAccount() {
        int rows = repo.deleteAll();
        return rows > 0;
    }

    private DemographicInfo createDemographicInfo(DemographicInfo demographicInfo){
        repo = new DemographicInfoRepositoryImpl(App.getAppContext());
        return repo.save(demographicInfo);
    }
}
