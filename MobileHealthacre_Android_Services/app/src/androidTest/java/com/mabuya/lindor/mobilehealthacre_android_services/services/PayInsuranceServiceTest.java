package com.mabuya.lindor.mobilehealthacre_android_services.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Payer;
import com.mabuya.lindor.mobilehealthacre_android_services.services.Impl.PayInsuranceServiceImpl;

import junit.framework.Assert;


/**
 * Created by LILO on 2016/05/15.
 */
public class PayInsuranceServiceTest extends AndroidTestCase {

    private PayInsuranceServiceImpl payInsuranceService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), PayInsuranceServiceImpl.class);
        this.getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            PayInsuranceServiceImpl.PayInsurance binder = (PayInsuranceServiceImpl.PayInsurance) service;
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    public void testPaid() throws Exception {
        Boolean insurancePaid = payInsuranceService.insurancePaid();
        Assert.assertEquals("SUCCESSFUL", insurancePaid);
    }

    public void testNotPaid() throws Exception {
        Boolean notPaid = payInsuranceService.insuranceNotPaid();
        Assert.assertEquals("FAIL", notPaid);
    }
}
