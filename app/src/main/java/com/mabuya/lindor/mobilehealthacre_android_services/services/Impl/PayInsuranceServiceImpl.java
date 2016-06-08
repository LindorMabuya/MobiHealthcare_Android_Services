package com.mabuya.lindor.mobilehealthacre_android_services.services.Impl;

//This is a Bound Service
//Bound service are services that offer interactions between the client and server, in this application
//the customer must log in and pay their insurance cover account and feedback from the server is required.

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.mabuya.lindor.mobilehealthacre_android_services.config.util.DomainState;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.Payer;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.PayerRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.PayerRepositoryImpl;
import com.mabuya.lindor.mobilehealthacre_android_services.services.PayInsuranceService;

public class PayInsuranceServiceImpl extends Service implements PayInsuranceService {

    private final IBinder localBinder = new PayInsurance();
    private PayerRepository payerRepository;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    private class PayInsurance extends Binder{
        public PayInsuranceServiceImpl getService(){
            return PayInsuranceServiceImpl.this;
        }
    }

    @Override
    public String logIn(Long id, String accNum, String accType, String bankName) {
        if(true){
            Payer payer = new Payer.Builder()
                    .id(id)
                    .accNum(accNum)
                    .accType(accType)
                    .bankname(bankName)
                    .build();

            createPayer(payer);
            return DomainState.SUCCEEDED.name();
        }else{
            return DomainState.FAILED.name();
        }
    }

    @Override
    public boolean insurancePaid() {
        return payerRepository.findAll().size() > 0;
    }

    @Override
    public boolean insuranceNotPaid() {
        int row = payerRepository.deleteAll();
        return row > 0;
    }

    private Payer createPayer(Payer payer){
        payerRepository = new PayerRepositoryImpl(this.getApplicationContext());
        return payerRepository.save(payer);
    }
}
