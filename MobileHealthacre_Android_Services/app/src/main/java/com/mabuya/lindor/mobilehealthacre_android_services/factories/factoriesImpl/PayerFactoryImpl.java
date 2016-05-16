package com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Payer;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.PayerFactory;

/**
 * Created by LILO on 2016/05/07.
 */
public class PayerFactoryImpl implements PayerFactory {
    public static  PayerFactoryImpl  payerFactory = null;

    public PayerFactoryImpl(){
    }

    public static PayerFactoryImpl getInstance(){
        if(payerFactory == null)
            payerFactory = new PayerFactoryImpl();
        return payerFactory;
    }

    @Override
    public Payer createPayer(Long id, String accNum, String accType, String bankName) {
        Payer payer = new Payer.Builder().id(id).accNum(accNum).accType(accType)
                .bankname(bankName).build();
        return payer;
    }
}
