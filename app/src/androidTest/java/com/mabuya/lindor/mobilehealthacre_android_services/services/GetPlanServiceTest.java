package com.mabuya.lindor.mobilehealthacre_android_services.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.mabuya.lindor.mobilehealthacre_android_services.config.util.App;
import com.mabuya.lindor.mobilehealthacre_android_services.domain.Plan;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepository.PlanRepository;
import com.mabuya.lindor.mobilehealthacre_android_services.repository.domainRepositoryImpl.PlanRepositoryImpl;
import com.mabuya.lindor.mobilehealthacre_android_services.services.Impl.GetPlanServiceImpl;

import junit.framework.Assert;

/**
 * Created by LILO on 2016/05/12.
 */
public class GetPlanServiceTest extends AndroidTestCase{

    private GetPlanService service;
    private PlanRepository planRepository;
    private Plan plan;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        planRepository = new PlanRepositoryImpl(this.getContext());
    }

    public void testGetPlan() throws Exception {
        long id;
        Intent intent = new Intent(App.getAppContext(), PlanRepositoryImpl.class);
        service = new GetPlanServiceImpl();

        Plan plan1 = new Plan.Builder()
                .id(123456789L)
                .riskCover("Health")
                .fixedIncomeReturn(800000)
                .tax(14)
                .build();

        service.getPlan(App.getAppContext(), plan1);
        App.getAppContext().startService(intent);
        id = plan1.getId();

        Assert.assertNotNull("CREATE", plan1);
    }
}
