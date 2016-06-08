package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Plan;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl.PlanFactoryImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by LILO on 2016/04/08.
 */
public class PlanFactoryTest {
    private PlanFactory planFactory;
    private Plan plan;

    @Before
    public void setUpPlan() throws Exception {
        planFactory = PlanFactoryImpl.getInstance();

    }

    @Test
    public void testPlan() throws Exception {
        plan = planFactory.createPlan(123456789L,"Accidental Death",800000,14);
        Assert.assertEquals(plan.getTax(),14);
    }

    @Test
    public void testPlanUpdate() throws Exception {
        plan = planFactory.createPlan(123456789L,"Accidental Death",800000,14);
        Plan updatePlan = new Plan.Builder().copy(plan).tax(20).build();
        Assert.assertEquals(updatePlan.getTax(),20);
    }
}
