package com.mabuya.lindor.mobilehealthacre_android_services.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.config.util.App;
import com.mabuya.lindor.mobilehealthacre_android_services.services.Impl.GetPlanServiceImpl;

/**
 * Created by LILO on 2016/05/12.
 */
public class GetPlanServiceTest extends AndroidTestCase{

    private GetPlanServiceImpl getPlanService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(),GetPlanServiceImpl.class );
        App.getAppContext().startService(intent);
    }

    public void testGetPlan() throws Exception {

    }
}
