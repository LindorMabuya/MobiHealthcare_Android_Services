package com.mabuya.lindor.mobilehealthacre_android_services.factories.factoriesImpl;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Plan;
import com.mabuya.lindor.mobilehealthacre_android_services.factories.PlanFactory;

/**
 * Created by LILO on 2016/04/08.
 */
public class PlanFactoryImpl  implements PlanFactory {

    private static PlanFactoryImpl planFactory = null;

    private PlanFactoryImpl(){}

    public static PlanFactoryImpl getInstance(){
        if(planFactory == null)
            planFactory = new PlanFactoryImpl();
            return planFactory;
    }

    @Override
    public Plan createPlan(Long id, String riskCover, double fixedIncomeReturn, double tax) {
        Plan plan = new Plan.Builder().id(id).riskCover(riskCover).fixedIncomeReturn(fixedIncomeReturn)
                .tax(tax).build();
        return plan;
    }
}
