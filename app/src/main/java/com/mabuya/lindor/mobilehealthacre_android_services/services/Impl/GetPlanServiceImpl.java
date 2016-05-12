package com.mabuya.lindor.mobilehealthacre_android_services.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Plan;
import com.mabuya.lindor.mobilehealthacre_android_services.services.GetPlanService;

//This is an Intent Service//
/*This application is meant to get/download the insurance Plan the customer will be insured for
* The Intent Service is good because because it won't affect interfere with the user experience */

public class GetPlanServiceImpl extends IntentService implements GetPlanService {

    private static GetPlanServiceImpl service = null;

    public static  GetPlanServiceImpl getInstance(){
        if(service == null)
            service = new GetPlanServiceImpl();
        return service;
    }

    public GetPlanServiceImpl() {
        super("GetPlanServiceImpl");
    }

    @Override
    public void getPlan(Context context) {
        Intent intent = new Intent(context, GetPlanServiceImpl.class);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
     //download plan
    }
}

