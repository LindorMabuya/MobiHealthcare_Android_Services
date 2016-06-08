package com.mabuya.lindor.mobilehealthacre_android_services.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.widget.Toast;

import com.mabuya.lindor.mobilehealthacre_android_services.config.util.App;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.Plan;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.PlanRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.PlanRepositoryImpl;
import com.mabuya.lindor.mobilehealthacre_android_services.services.GetPlanService;

//This is an Intent Service//
/*This application is meant to get/download the insurance Plan the customer will be insured for
* The Intent Service is good because because it won't affect interfere with the user experience */

public class GetPlanServiceImpl extends IntentService implements GetPlanService {
    private final PlanRepository planRepository;
    private static GetPlanServiceImpl service = null;

    private static final String ACTION_ADD = "package com.mabuya.lindor.mobilehealthacre_android_services.services.Impl.action.ADD";
    private static final String EXTRA_ADD = "package com.mabuya.lindor.mobilehealthacre_android_services.services.Impl.extra.ADD";

    public GetPlanServiceImpl() {
        super("GetPlanServiceImpl");
        planRepository = new PlanRepositoryImpl(App.getAppContext());
    }

    public static  GetPlanServiceImpl getInstance(){
        if(service == null)
            service = new GetPlanServiceImpl();
        return service;
    }

    @Override
    public void getPlan(Context context, Plan plan) {
        Intent intent = new Intent(context,GetPlanServiceImpl.class);
        intent.setAction(ACTION_ADD);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Plan planResources = (Plan)intent.getSerializableExtra(EXTRA_ADD);
        Plan plan = new Plan.Builder()
                .id(planResources.getId())
                .riskCover(planResources.getRiskCover())
                .fixedIncomeReturn(planResources.getFixedIncomeReturn())
                .tax(planResources.getFixedIncomeReturn())
                .build();
        try {
            planRepository.save(plan);
        }catch (SQLException e){
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(),"Plan has been downloaded",Toast.LENGTH_LONG).show();
    }
}

