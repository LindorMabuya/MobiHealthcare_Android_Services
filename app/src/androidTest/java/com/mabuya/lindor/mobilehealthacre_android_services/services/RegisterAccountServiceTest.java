package com.mabuya.lindor.mobilehealthacre_android_services.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.config.util.App;
import com.mabuya.lindor.mobilehealthacre_android_services.services.Impl.RegisterAccountServiceImpl;

import org.junit.Assert;

/**
 * Created by LILO on 2016/05/12.
 */
public class RegisterAccountServiceTest extends AndroidTestCase {

    private RegisterAccountServiceImpl registerService;
    private  boolean isBound;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(),RegisterAccountServiceImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            RegisterAccountServiceImpl.RegisterServiceBinder binder = ( RegisterAccountServiceImpl.RegisterServiceBinder) service;
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    public void testRegisterAccount() throws Exception {
        String activate = registerService.activateAccount("lindor@gmail.com","lindo123#");
        Assert.assertEquals("ACTIVATED", activate);
    }

    public void testIsAccountActivated() throws Exception {
        Boolean activated = registerService.isAccountActivated();
        Assert.assertEquals("ACTIVATED", activated);
    }

    public void testDeactivateAccount() throws Exception {
        Boolean deactivate = registerService.deactivateAccount();
        Assert.assertEquals("ACTIVATED", deactivate);
    }
}
