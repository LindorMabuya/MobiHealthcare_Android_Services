package com.mabuya.lindor.mobilehealthacre_android_services.factories;

import com.mabuya.lindor.mobilehealthacre_android_services.domain.Plan;

/**
 * Created by LILO on 2016/04/08.
 */
public interface PlanFactory {
    Plan createPlan(Long id, String riskCover, double fixedIncomeReturn, double tax);
}
